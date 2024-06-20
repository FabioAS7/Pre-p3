package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MetodosArq 
{
	public void lerArquivo(String unit) throws IOException
	{
		String arq = "exchange.json";
		String os = System.getProperty("os.name");
		String path = os.contains("Windows")?("C:\\TEMP"):("/tmp");
		
		File diretorio = new File(path);
		if(diretorio.exists() && diretorio.isDirectory())
		{
			File arquivo = new File(path, arq);
			if (arquivo.exists() && arquivo.isFile())
			{
				lerConteudo(arquivo, unit);
			}
			else
			{
				throw new IOException("Arquivo nao encontrado\naArquivo procurado: " + arq);
			}
		}
		else
		{
			throw new IOException("Diretorio nao encontrado\nPatch procurado: " + path);
		}
	}
	
	private void lerConteudo(File arquivo, String unit) throws IOException
	{
		FileInputStream fluxo = new FileInputStream(arquivo);
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(leitor);
		String linha = buffer.readLine();
		
		String[] vet = linha.split("},");
		String[] aux;
		
		for(String a: vet)
		{
			if(a.contains(unit))
			{
				aux = a.split(",");
				
				for(String b: aux)
				{
					if(b.contains("unit") || b.contains("value"))
					{
						System.err.println(b);
					}
				}
				System.out.println(a);
			}
		}
	}
}