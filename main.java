import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // Lista para armazenar os índices iniciais dos substrings que são concatenação de todas as palavras
        List<Integer> result = new ArrayList<>();
        // Caso base: se 's' ou 'words' forem nulos ou vazios, retorna a lista vazia
        if (s == null || words == null || words.length == 0) return result;

        // Mapa para contar a frequência de cada palavra em 'words'
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word : words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }

        // Calcula o comprimento de cada palavra (assumindo que todas têm o mesmo tamanho) e o comprimento total de todas as palavras combinadas
        int wordLength = words[0].length();
        Map<String, Integer> windowCounts = new HashMap<>();

        // Loop principal para verificar cada possível posição inicial dentro de 's'
        for (int i = 0; i < wordLength; ++i) {
            // 'left' e 'right' são ponteiros para o início e o fim da janela atual, respectivamente
            // 'count' é usado para rastrear quantas palavras válidas foram encontradas na janela atual
            int left = i, right = i, count = 0;
            windowCounts.clear();
            
            // Enquanto o fim da janela não ultrapassar o fim da string 's'
            while (right + wordLength <= s.length()) {
                // Extrai a palavra atual da janela e avança o ponteiro 'right'
                String w = s.substring(right, right + wordLength);
                right += wordLength;
                
                // Se a palavra atual está em 'wordsCount', incrementa sua contagem em 'windowCounts'
                if (wordsCount.containsKey(w)) {
                    windowCounts.put(w, windowCounts.getOrDefault(w, 0) + 1);
                    count++;
                    
                    // Se a contagem de 'w' em 'windowCounts' excede a contagem em 'wordsCount', move 'left' para frente
                    while (windowCounts.get(w) > wordsCount.get(w)) {
                        String leftWord = s.substring(left, left + wordLength);
                        windowCounts.put(leftWord, windowCounts.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }
                    
                    // Se todas as palavras foram encontradas na janela atual, adiciona o índice 'left' à lista de resultados
                    if (count == words.length) {
                        result.add(left);
                    }
                } else {
                    // Se a palavra atual não está em 'wordsCount', reinicia a janela
                    windowCounts.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        
        return result;
    }
}

 // A principal otimização realizada no código acima foi reutilizar o mapa `windowCounts` ao invés de criar um novo a cada iteração. Isso reduz significativamente o número de objetos que precisam ser alocados durante a execução do programa, economizando memória.
