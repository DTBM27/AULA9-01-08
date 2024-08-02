import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OrdenarDecrescente {

    static class No {
        int dado;
        No esquerda, direita;

        public No(int item) {
            dado = item;
            esquerda = direita = null;
        }
    }

    static class ArvoreBinariaBusca {
        No raiz;

        void inserir(int dado) {
            raiz = inserirRecursivamente(raiz, dado);
        }

        No inserirRecursivamente(No raiz, int dado) {
            if (raiz == null) {
                raiz = new No(dado);
                return raiz;
            }
            if (dado < raiz.dado)
                raiz.esquerda = inserirRecursivamente(raiz.esquerda, dado);
            else if (dado > raiz.dado)
                raiz.direita = inserirRecursivamente(raiz.direita, dado);
            return raiz;
        }

        void ordemInversa() {
            ordemInversaRecursiva(raiz);
        }

        void ordemInversaRecursiva(No raiz) {
            if (raiz != null) {
                ordemInversaRecursiva(raiz.direita);
                System.out.print(raiz.dado + " ");
                ordemInversaRecursiva(raiz.esquerda);
            }
        }
    }

    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\TOPNET\\Desktop\\Hospital\\dados500_mil.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] numeros = linha.split(", ");
                for (String numero : numeros) {
                    try {
                        int num = Integer.parseInt(numero.trim());
                        arvore.inserir(num);
                    } catch (NumberFormatException e) {
                        System.out.println(numero);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("RESULTADO ORDENADO:");
        arvore.ordemInversa();
    }
}
