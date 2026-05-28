# Documentação da Implementação — Lista Encadeada de Alunos com Notas

## 1. Introdução

Este projeto implementa uma estrutura de dados do tipo **lista encadeada simples ordenada**, usada para armazenar alunos e suas notas.

A ideia principal é manter os registros organizados em ordem decrescente de desempenho, permitindo inserir, remover e buscar alunos de forma prática.

O projeto foi desenvolvido com foco em conceitos de **Estrutura de Dados**, principalmente:

- listas encadeadas;
- nó sentinela;
- ordenação durante a inserção;
- busca linear;
- remoção por chave.

---

## 2. Problema proposto

O problema consiste em representar uma turma de alunos em uma estrutura que permita:

- armazenar os dados pessoais de cada aluno;
- associar uma nota a cada aluno;
- manter os alunos ordenados pela nota;
- localizar alunos por nota, matrícula ou cidade;
- remover um aluno específico;
- identificar quantos alunos existem na lista.

Em vez de usar apenas vetores ou coleções prontas, o projeto demonstra a implementação manual de uma lista encadeada, o que é útil para fins didáticos.

---

## 3. Solução adotada

A solução foi dividir o sistema em três partes principais:

### `Aluno`
Classe que representa os dados do aluno.

### `ListaNotas`
Classe responsável por armazenar os alunos em uma lista encadeada ordenada por nota.

### `TesteListaAluno`
Classe principal que cria os objetos, insere dados e executa as operações de teste.

---

## 4. Estrutura do projeto

Arquivos principais:

- `src/main/java/com/ifgoiano/models/Aluno.java`
- `src/main/java/com/ifgoiano/services/ListaNotas.java`
- `src/main/java/com/ifgoiano/TesteListaAluno.java`

---

## 5. Classe `Aluno`

Arquivo: `src/main/java/com/ifgoiano/models/Aluno.java`

Essa classe modela um aluno com seus dados básicos.

### Atributos

- `matricula`: identifica de forma única o aluno;
- `nome`: nome completo ou nome de registro;
- `curso`: curso em que o aluno está matriculado;
- `endereco`: cidade ou local de residência;
- `telefone`: número de contato.

### Construtor

O construtor recebe todos os atributos e inicializa o objeto.

### Métodos

A classe fornece métodos `get` e `set` para cada atributo, permitindo leitura e alteração dos dados.

### Papel na solução

Ela funciona como entidade de domínio, ou seja, representa o objeto real que será armazenado na lista.

---

## 6. Classe `ListaNotas`

Arquivo: `src/main/java/com/ifgoiano/services/ListaNotas.java`

Essa é a classe mais importante do projeto. Ela implementa uma **lista encadeada simples ordenada por nota**.

### 6.1 Estrutura interna

A classe possui uma classe interna privada chamada `Nodo`.

Cada `Nodo` armazena:

- `Aluno aluno`: o aluno associado ao nó;
- `float nota`: a nota do aluno;
- `Nodo prox`: referência para o próximo nó.

### 6.2 Nó sentinela

A lista utiliza um nó inicial chamado `head`, que não representa um aluno real.

Esse nó sentinela facilita as operações de inserção e remoção, porque evita tratar casos especiais quando a lista está vazia ou quando a alteração acontece no primeiro elemento.

A classe também guarda a referência `ultimo`, que aponta para o último nó da lista.

---

## 7. Funcionamento dos métodos de `ListaNotas`

### 7.1 `insercaoEmOrdem(Aluno aluno, float nota)`

Insere um novo aluno na posição correta da lista, mantendo a ordem decrescente das notas.

#### Como funciona
1. Cria um novo nó com o aluno e a nota informados.
2. Percorre a lista a partir do `head`.
3. Busca o ponto em que a nova nota deve ser inserida.
4. Faz o encadeamento do novo nó.
5. Atualiza `ultimo` se o novo nó for o último da lista.

#### Regra de ordenação
Notas maiores ficam mais próximas do início da lista.

#### Exemplo
Se os valores forem:

- 7.4
- 6.7
- 5.2
- 4.3

A lista ficará exatamente nessa ordem.

---

### 7.2 `remocaoPorMatricula(String matricula)`

Remove o aluno cuja matrícula é igual ao valor informado.

#### Como funciona
1. Percorre a lista até encontrar o nó anterior ao aluno desejado.
2. Reaponta o ponteiro `prox` para “pular” o nó removido.
3. Atualiza `ultimo` caso o último elemento tenha sido removido.

#### Caso a matrícula não exista
O método não altera a lista e apenas encerra a execução.

---

### 7.3 `buscaPorNota(float nota)`

Procura o primeiro aluno que possua a nota informada.

#### Como funciona
1. Percorre todos os nós da lista.
2. Compara o valor da nota de cada nó.
3. Retorna o aluno assim que encontrar a correspondência.

#### Caso não encontre
O método imprime:

```text
Aluno não encontrado!
```

E retorna `null`.

---

### 7.4 `buscaPorMatricula(Aluno aluno)`

Busca um aluno pela matrícula, recebendo um objeto `Aluno` como parâmetro.

#### Como funciona
1. Extrai a matrícula do objeto recebido.
2. Percorre a lista.
3. Compara a matrícula de cada nó.
4. Retorna o aluno encontrado.

#### Caso não encontre
O método imprime:

```text
Aluno não encontrado!
```

E retorna `null`.

---

### 7.5 `buscaPorCidade(String cidade)`

Retorna todos os alunos cuja cidade seja igual ao valor informado.

#### Como funciona
1. Percorre toda a lista.
2. Verifica se o campo `endereco` é igual à cidade buscada.
3. Adiciona os alunos encontrados em uma lista auxiliar.
4. Retorna a lista com os resultados.

#### Caso não encontre
O método imprime:

```text
Aluno(s) não encontrado(s)!
```

E retorna `null`.

---

### 7.6 `tamanho()`

Retorna a quantidade total de alunos presentes na lista.

#### Como funciona
1. Percorre os nós da lista.
2. Conta cada elemento encontrado.
3. Retorna o número total.

---

## 8. Classe `TesteListaAluno`

Arquivo: `src/main/java/com/ifgoiano/TesteListaAluno.java`

Essa é a classe executável do projeto, contendo o método `main`.

### Responsabilidades

- criar objetos `Aluno`;
- criar a lista `ListaNotas`;
- inserir alunos com suas respectivas notas;
- realizar buscas;
- remover um aluno;
- imprimir os resultados no console.

---

## 9. Dados utilizados no teste

No método `getListaNotas()`, são criados quatro alunos:

### 1. Jefferson
- Matrícula: `15010`
- Curso: `Sistemas de Informação`
- Cidade: `Orizona`
- Telefone: `64998888`
- Nota: `6.7`

### 2. Flávio
- Matrícula: `15011`
- Curso: `Sistemas de Informação`
- Cidade: `Orizona`
- Telefone: `64998383`
- Nota: `7.4`

### 3. Paulo
- Matrícula: `15012`
- Curso: `Sistemas de Informação`
- Cidade: `Orizona`
- Telefone: `64994788`
- Nota: `5.2`

### 4. João
- Matrícula: `15013`
- Curso: `Sistemas de Informação`
- Cidade: `Urutaí`
- Telefone: `64994777`
- Nota: `4.3`

---

## 10. Ordem final da lista após as inserções

Como a inserção é ordenada por nota de forma decrescente, a lista final fica:

1. Flávio — `7.4`
2. Jefferson — `6.7`
3. Paulo — `5.2`
4. João — `4.3`

---

## 11. Passo a passo da execução

### Etapa 1: criação da lista
A classe `TesteListaAluno` chama o método `getListaNotas()`.

### Etapa 2: inserção dos alunos
Os alunos são inseridos com suas notas, e a estrutura se organiza automaticamente.

### Etapa 3: busca pelo menor desempenho
O programa executa:

```java
lista.buscaPorNota(4.3f);
```

O aluno encontrado é **João**.

### Etapa 4: remoção por matrícula
O programa remove o aluno de matrícula `15010`, que é **Jefferson**.

### Etapa 5: busca por cidade
O programa busca todos os alunos da cidade de **Orizona**.

Depois da remoção, os alunos encontrados são:

- Flávio
- Paulo

### Etapa 6: exibição do tamanho
Ao final, a lista contém **3 elementos**.

---

## 12. Saída esperada no console

A execução produz uma saída semelhante à seguinte:

```text
Alunos com menor desempenho:
João

Aluno Jefferson removido!

Alunos de Orizona:
Flávio
Paulo

Tamanho da lista: 3
```

---

## 13. Análise da solução

### Pontos fortes

- A lista já é mantida ordenada na inserção;
- A estrutura é simples e boa para estudo;
- O nó sentinela facilita o gerenciamento da lista;
- As operações principais foram implementadas de forma objetiva.

### Limitações observadas

- A busca é linear, então o custo cresce conforme o tamanho da lista;
- A comparação de `float` com `==` pode ser sensível em situações reais;
- O método `buscaPorMatricula` poderia receber apenas a matrícula, em vez de um objeto `Aluno`;
- Quando não encontra resultados, `buscaPorCidade` retorna `null`, o que exige tratamento no uso.

---

## 14. Conclusão

Este projeto apresenta uma implementação funcional de uma lista encadeada ordenada para armazenar alunos e suas notas.

Ele demonstra conceitos importantes de Estrutura de Dados, como:

- criação de nós encadeados;
- uso de nó sentinela;
- inserção ordenada;
- busca sequencial;
- remoção por chave.

Além de servir como exercício acadêmico, a implementação também mostra como organizar objetos em uma estrutura dinâmica, permitindo consultas e manipulações com base em critérios diferentes.

---

## 15. Arquivos principais

- `src/main/java/com/ifgoiano/models/Aluno.java`
- `src/main/java/com/ifgoiano/services/ListaNotas.java`
- `src/main/java/com/ifgoiano/TesteListaAluno.java`

---

## 16. Observação final

Se desejar, esta documentação pode ser expandida com:

- capa de trabalho acadêmico;
- objetivos geral e específicos;
- diagrama da estrutura da lista;
- fluxograma das operações;
- melhoria da formatação para entrega formal.

