import random

nome_arquivo = 'editoras.txt'
arquivo = open(nome_arquivo, 'w')    
arquivo.seek(0)
nomeEditora = ['EDITORA_1', 'EDITORA_2', 'EDITORA_3']
ruaEditora = ['Rua Editora 1', 'Rua Editora 2', 'Rua Editora 3']
numEditora = ['(55)123456789', '(47)313646979', '(22)314253659']
cnpjEditora = ['08.357.578/0001-01', '10.468.689/0002-02', '12.863.986/0003-03']

for i in range(len(nomeEditora)):
	texto = nomeEditora[i] + ';' + ruaEditora[i] + ';' + numEditora[i] + ';' + cnpjEditora[i] + '\n'
	arquivo.write(texto)
arquivo.close()
