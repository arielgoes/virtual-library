import random

nome_arquivo = 'livros.txt'
arquivo = open(nome_arquivo, 'w')
arquivo.seek(0)
material = ['CAPA DURA', 'BORRACHA', 'PLASTICO']
preco = ['10', '20', '30', '40', '50', '60', '100']
autor = ['STEPHEN KING', 'BERNARD CORNWELL', 'KARL MARX', 'CARL SEGAN', 'LUDWIG VON MISES', 'HANS HERMANN_HOPPE']
categoria = ['ADMINISTRACAO','AGROPECUARIA','ARTES','AUDIOLIVRO','AUTOAJUDA','CIENCIAS BIOLOGICAS','CIENCIAS EXATAS','CIENCIAS HUMANAS E SOCIAIS',
'CONTABILIDADE','CURSOS E IDIOMAS','DICIONARIOS E MANUAIS CONVERSACAO','DIDATICOS','DIREITO','ECONOMIA','ENGENHARIA E TECNOLOGIA',
'ESOTERISMO','ESPIRITISMO','ESPORTES E LAZER','GASTRONOMIA','GEOGRAFIA E HISTORIA','HQS','INFORMATICA','LINGUISTICA','LITERATURA ESTRANGEIRA',
'LITERATURA INFANTOJUVENIL','LITERATURA NACIONAL','MEDICINA','PSICOLOGIA E PSICANALISE','RELIGIAO','TURISMO']
editora = ['EDITORA 1', 'EDITORA 2', 'EDITORA 3']

for i in range(50):
	randPreco = int(random.choice(preco))
	texto = str(i) + ';' + 'Livro ' + str(i) + ';' + 'Livro ' + str(i) + ' eh o ' + str(i) + '-esimo livro;' + random.choice(material) + ';' + '00/00/0000;' + str(randPreco) + '.0;' + str(randPreco/2) + ';' + str(random.choice(categoria)) + ';' + random.choice(editora) +  ';' + random.choice(autor) + '\n'  
	arquivo.write(texto)

arquivo.close()
