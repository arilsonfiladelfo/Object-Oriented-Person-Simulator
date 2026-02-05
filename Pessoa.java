public class Pessoa {

    private String nome;

    private boolean acordado;

    private boolean comendo;

    private boolean dirigindo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome invalido, ele deve ser preenchido corretamente.");
        }
        this.nome = nome;
    }

    public boolean isAcordado() {
        return acordado;
    }

    public boolean isComendo() {
        return comendo;
    }

    public boolean isDirigindo() {
        return dirigindo;
    }


    // ==================================================================

    Pessoa(String nome) {
        this.setNome(nome);
        this.acordado = false;
        this.comendo = false;
        this.dirigindo = false;
    }

    public void visualizarPessoa() {

        System.out.println("Nome: " + getNome());

        System.out.println("Acordado: " + isAcordado());

        System.out.println("Comendo: " + isComendo());

        System.out.println("Digirindo: " + isDirigindo());

    }

    public void acordar() {
        if (isAcordado()) {
            System.out.printf("%s está acordado.%n", getNome());
        } else {
            this.acordado = true;
            System.out.printf("Acordando %s.%n", getNome());
        }
    }

    public void comer() {

        if (dirigindo) {
            System.out.println("Você deve parar de dirigir para poder comer!");
            return;
        }

        if (!acordado) {
            System.out.println("Não é possivel comer enquanto dorme!");
            return;
        }

        if (comendo) {
            System.out.printf("%s já está comendo!%n", getNome());
            return;
        }
        comendo = true;
        System.out.printf("%s começa a comer.%n", getNome());

    }

    public void pararDeComer() {
        if (comendo) {
            System.out.println("Refeição finalizada!");
            comendo = false;
        } else {
            System.out.printf("%s não está fazendo nenhuma refeição!%n", getNome());
        }
    }

    public void dirigir() {
        if (comendo) {
            System.out.println("Não é possivel dirigir enquanto come!");
            return;
        }

        if (!acordado) {
            System.out.println("Não é possivel dirigir enquanto dorme!");
            return;
        }
        if (dirigindo) {
            System.out.printf("%s já está dirigindo!%n", getNome());
            return;
        }
        dirigindo = true;
        System.out.printf("%s pega seu veiculo e começa seu trajeto.", getNome());
    }

    public void pararDeDirigir() {
        if (dirigindo) {
            dirigindo = false;
            System.out.println("Parando o veiculo.");
        } else {
            System.out.println("O veiculo já está parado!");
        }
    }

    public void dormir() {

        if (comendo) {
            System.out.println("Não é possivel dormir enquanto come!");
            System.out.println("Pare de comer antes.");
            return;
        }
        if (dirigindo) {
            System.out.println("Não é possivel dormir enquando conduz um veiculo!");
            System.out.println("Evite acidentes de transito, pare seu veiculo e durma.");
            return;
        }
        if (!acordado) {
            System.out.printf("%s já está dormindo.%n", getNome());
            return;
        }
        acordado = false;
        System.out.printf("%s se deita e começa a dormir.%n", getNome());
    }
}
