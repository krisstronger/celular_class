package tipopruebaprogra;

import java.util.Scanner;

public class Celular {
    //realizar metodo cargar, recive entero monto no retorna nada sube el saldo
    //realIZAR metodo hablar int minutos (se descuenta 70pesos x min)
    //realizar metodo activar(no se puede hacer ningun metodo si no esta activado)
    //realizar metodo cambiar clave(string)(clave x defecto son los 4 primeros numeros del imei)devuelve boolean
    //reazlizar metodo restaurar(string clave)pide la clave x defecto, si ingresa clave 3 veces seguidas mal se bloquea,si la clave esta bien deja estado como inactivo, y saldo en 0
    //realizar metodo ingresar clave(string clave): devuelve boolean??????????
    //si el telefono se bloquea, solo se puede restaurar, se restaura con la clave x defecto

    private int imei;//solo get
    private int numero;//set y get
    private int saldo;//get
    private String propietario;//set y get
    private String clave;//sin get ni set
    private String estado;//solo get: inactivo - activo - bloqueado
    

    //CONSTRUCTORES
    public Celular(int imei) {
        this.imei = imei;
        String aux = "";
        aux = Integer.toString(imei);
        aux = aux.substring(0, 4);
        String pass = aux;
        this.clave = aux;
        this.estado = "Inactivo";
    }

    public Celular(int imei, int numero) {
        this(imei);
        this.numero = numero;
        this.estado = "Inactivo";
    }

    public Celular(int imei, int numero, String dueño) {
        this(imei, numero);
        this.propietario = dueño;
        this.estado = "Inactivo";
    }
    //AQUI TERMINAN LOS CONSTRUCTORES DE LA CLASE 
    

//METODOS SET
    public boolean activar(String pass) {
        if ("Bloqueado".equals(estado)) {
            System.out.println("El celular esta bloqueado, restaurelo para usar este metodo");
        }
        if (this.clave.equals(pass) && estado.equals("inactivo")) {
            this.clave = pass;
        }
        this.estado = "Activado";
        return true;
    }

    public void cargar(int carga) {
        if ("Bloqueado".equals(estado)) {
            System.out.println("El celular esta bloqueado, restaurelo para usar este metodo");
        }

        if ("Activado".equals(estado)) {
            this.saldo = saldo + carga;
        }

    }

    public void hablar(int minutos) {
        if ("Bloqueado".equals(estado)) {
            System.out.println("El celular esta bloqueado, restaurelo para usar este metodo");
        }
        if ("Activado".equals(estado) && this.saldo >= 70) {
            this.saldo = saldo - (minutos * 70);
        } else {
            System.out.println("Saldo insuficiente, debe cargar saldo primero");
        }
    }

    public boolean cambiarClave(String clave2) {
        if (estado.equals("Bloqueado")) {
            System.out.println("El celular esta bloqueado, restaurelo para usar este metodo");
        }
        if (estado.equals("Activado")) {
            Scanner leer = new Scanner(System.in);
            int intento = 1;

            while (intento <= 3) {
                System.out.print("Ingrese la clave por defecto: ");
                String x = leer.nextLine();
                if (this.clave.equals(x)) {
                    System.out.print("Ingrese la nueva clave: ");
                    String nueva = leer.nextLine();
                    this.clave = clave2;
                    intento = 4;
                } else {
                    System.out.println("La clave es incorrecta, le quedan " + (3 - intento) + " intentos");
                    intento++;
                    if (x != clave && intento == 3) {
                        this.estado = "Bloqueado";

                    }

                }

            }
        }
        return true;
    }
    

    public void restaurar() {

        Scanner leer = new Scanner(System.in);
        int intento = 1;

        while (intento <= 3) {
            System.out.print("Restaurar, ingrese la clave por defecto: ");
            String x = leer.nextLine();
            if (this.clave.equals(x)) {
                this.estado = "Inactivo";
                this.saldo = 0;
                intento = 4;
            } else {
                System.out.println("La clave es incorrecta, le quedan " + (3 - intento) + " intentos");
                intento++;
                if (x != clave && intento == 3) {
                    this.estado = "Bloqueado";

                }

            }

        }
    }

    public void setNumero(int numero) {
       if (estado.equals("Bloqueado")) {
            System.out.println("El celular esta bloqueado, restaurelo para usar este metodo");
        }
        if ("Activado".equals(estado)) {
            this.numero = numero;
        }
    }

    public void setPropietario(String propietario) {
        if ("Bloqueado".equals(estado)) {
            System.out.println("El celular esta bloqueado, restaurelo para usar este metodo");
        }
        if ("Activado".equals(estado)) {
            this.propietario = propietario;
        }
    }

    //METDOS GET
    public int getImei() {
        return this.imei;
    }

    public int getNumero() {
        return this.numero;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public String getPropietario() {
        return this.propietario;
    }

    public String getEstado() {
        return this.estado;
    }

    //get para probar clave, borrar metodo despues
    public String getClave() {
        return this.clave;
    }

}
