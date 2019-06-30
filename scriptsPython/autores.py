import random

nome_arquivo = 'autores.txt'
arquivo = open(nome_arquivo, 'w')    
arquivo.seek(0)
autor = ['STEPHEN KING', 'BERNARD CORNWELL', 'KARL MARX', 'CARL SEGAN', 'LUDWIG VON MISES', 'HANS HERMANN HOPPE']
editora = ['EDITORA 1', 'EDITORA 2', 'EDITORA 3']

for a in range(len(autor)):
	texto = autor[a] + ';' + '00/00/0000;' + '00/00/0000;' + 'ALEGRETE;' + 'PORTO_ALEGRETE;' + 'UM MERO ESCRITOR;' + '\n'
	arquivo.write(texto)		
arquivo.close()
