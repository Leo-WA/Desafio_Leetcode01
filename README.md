# Projeto: Substring com Concatenação de Todas as Palavras

Este projeto aborda a solução de um problema de algoritmo interessante e desafiador. O objetivo é encontrar todos os índices iniciais de substrings dentro de uma string `s` que sejam a concatenação de todas as possíveis permutações de um array de palavras `words`. Cada palavra tem o mesmo comprimento, e a substring concatenada deve incluir todas as palavras, exatamente uma vez, possivelmente em qualquer ordem.

## Descrição do Problema

Dado uma string `s` e um array de strings `words`, onde todas as strings de `words` possuem o mesmo comprimento, o desafio é encontrar todas as substrings em `s` que sejam a concatenação de todas as permutações possíveis das palavras em `words`. O resultado deve ser uma lista de índices iniciais dessas substrings.

## Solução

A solução envolve o uso de uma técnica de janela deslizante combinada com mapas de hash para rastrear a contagem das palavras. Aqui está um esboço dos passos principais do algoritmo:

1. **Contagem de Palavras**: Primeiramente, contamos a frequência de cada palavra em `words` usando um mapa de hash.
2. **Janela Deslizante**: Percorremos a string `s` com uma janela do tamanho total de todas as palavras concatenadas. A cada passo, verificamos se a substring atual dentro da janela pode ser formada pela concatenação de todas as palavras em `words`.
3. **Verificação e Armazenamento de Resultados**: Se a substring na janela atual atender aos critérios, o índice inicial da janela é adicionado à lista de resultados.

### Implementação em Java

A implementação da solução em Java faz uso de um loop principal que itera sobre cada possível posição inicial da janela dentro de `s`. Para cada posição inicial, utilizamos dois ponteiros, `left` e `right`, para delimitar a janela atual. A medida que movemos `right` para explorar a string `s`, usamos um mapa de hash `windowCounts` para contar as palavras dentro da janela atual e comparamos com o mapa `wordsCount` que contém a contagem original das palavras em `words`.

## otimização

A principal otimização realizada no código acima foi reutilizar o mapa windowCounts ao invés de criar um novo a cada iteração. Isso reduz significativamente o número de objetos que precisam ser alocados durante a execução do programa, economizando memória.
