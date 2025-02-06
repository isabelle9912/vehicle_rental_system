package models;

import java.util.Objects;

public class Client {
    private String name;
    private String cpf;
    private String phone;

    public Client(String name, String cpf, String phone) {
        setName(name);
        setCpf(cpf);
        setPhone(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException("CPF inválido! O formato correto é XXX.XXX.XXX-XX");
        }
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Se for o mesmo objeto na memória, são iguais
        if (obj == null || getClass() != obj.getClass()) return false;  // Se for nulo ou tipo diferente, são diferentes

        Client client = (Client) obj; // Faz o casting seguro
        return Objects.equals(getCpf(), client.getCpf()); // Compara apenas o CPF, que é único
    }


    public void showInfo(){
        System.out.println("Nome: " + getName() + "\nCpf: " + getCpf() + "\nTelefone: " + getPhone());
    }
}
