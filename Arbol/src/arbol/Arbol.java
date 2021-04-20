
/*

*

*/

package arbol;

// En este proyecto se va a hacer lo siguiente:

// Ingresar unos nodos a un árbol binario de búsqueda

// Ordenarlos de acuerdo a un árbol binario de búsqueda

// Listarlos con el recorrido Inorden

// Encontrar el mayor, la altura del árbol, los nodos hojas

// Retirar el nodo con menor valor

//

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

// Clase Publica Arbol el archivo debe ser de igual nombre

public class Arbol {

class Nodo

{

int info;

Nodo izq, der;

}

Nodo raiz;

int cant;

int altura;

public Arbol() {

raiz=null;

}

// Método para Insertar un nodo en un árbol Binario de búsqueda

// Las claves que ingresan van al subarbol izquierdo si son menores

// Las claves mayores al raíz van al subarbol derecho

public void insertar (int info) {

// Se verifica que la clave no exista. No Duplicados

if (!existe(info)) {

Nodo nuevo;

nuevo = new Nodo ();

nuevo.info = info;

nuevo.izq = null;

nuevo.der = null;

// si es el primero se coloca como raiz

if (raiz == null)

raiz = nuevo;

else {

// Si no es nuevo. se define si va a la Izq o Der

Nodo anterior = null, reco;

reco = raiz;

while (reco != null) {

anterior = reco;

if (info < reco.info)

reco = reco.izq;

else

reco = reco.der;

}

if (info < anterior.info)

anterior.izq = nuevo;

else

anterior.der = nuevo;

}

}

}

// Método para encontrar duplicados

public boolean existe(int info) {

Nodo reco=raiz;

while (reco!=null) {

if (info==reco.info)

return true;

else

if (info>reco.info)

reco=reco.der;

else

reco=reco.izq;

}

return false;

}

// Metodo para recorrido e impresion en Inorden

private void imprimirEntre (Nodo reco) {

if (reco != null) {

imprimirEntre (reco.izq);

System.out.print(reco.info + " ");

imprimirEntre (reco.der);

}

}

// Impresion InOrden

public void imprimirEntre () {

imprimirEntre (raiz);

System.out.println();

}

// Cuenta nro. de nodos del arbol - aqui se empea recursividad

private void cantidad(Nodo reco) {

if (reco!=null) {

cant++;

cantidad(reco.izq);

cantidad(reco.der);

}

}

public int cantidad() {

cant=0;

cantidad(raiz);

return cant;

}

// Cuenta el numero de nodos Hoja (no tienen hijos)

private void cantidadNodosHoja(Nodo reco) {

if (reco!=null) {

if (reco.izq==null && reco.der==null)

cant++;

cantidadNodosHoja(reco.izq);

cantidadNodosHoja(reco.der);

}

}

public int cantidadNodosHoja() {

cant=0;

cantidadNodosHoja(raiz);

return cant;

}

// Impresion de los nodos y el nivel

private void imprimirEntreConNivel (Nodo reco,int nivel) {

if (reco != null) {

imprimirEntreConNivel (reco.izq,nivel+1);

System.out.print(reco.info + " ("+nivel+") - ");

imprimirEntreConNivel (reco.der,nivel+1);

}

}

public void imprimirEntreConNivel () {

imprimirEntreConNivel (raiz,1);

System.out.println();

}

// Encontrar la altura de un arbol

private void retornarAltura (Nodo reco,int nivel) {

if (reco != null) {

retornarAltura (reco.izq,nivel+1);

if (nivel>altura)

altura=nivel;

retornarAltura (reco.der,nivel+1);

}

}

public int retornarAltura () {

altura=0;

retornarAltura (raiz,1);

return altura;

}

// metodo para encontrar el nodo de mayor valor

// debe encontrarse en el subarbol derecho

public void mayorValorl() {

if (raiz!=null) {

Nodo reco=raiz;

while (reco.der!=null)

reco=reco.der;

System.out.println("Mayor valor del arbol:"+reco.info);

}

}

// Borrar el nodo de menor clave

public void borrarMenor() {

if (raiz!=null) {

if (raiz.izq==null)

raiz=raiz.der;

else {

Nodo atras=raiz;

Nodo reco=raiz.izq;

while (reco.izq!=null) {

atras=reco;

reco=reco.izq;

}

atras.izq=reco.der;

}

}

}

// Metodo principal

public static void main (String [] ar) throws IOException

{

Arbol abo = new Arbol ();

int nm;

BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));

// Se crea arbol con los numeros de registro de los estudiantes

do {

System.out.print ("Numero de matricula (0 -> Fin): ");

nm = Integer.parseInt(entrada.readLine());

if (nm != 0)

{

abo.insertar (nm);

}

}while(nm != 0);

// Resutados encontrados

System.out.println ("Impresion InOrden: ");

abo.imprimirEntre ();

System.out.println ("Cantidad de nodos del arbol:"+abo.cantidad());

System.out.println ("Cantidad de nodos hoja:"+abo.cantidadNodosHoja());

System.out.println ("Impresion en entre orden junto al nivel del nodo.");

abo.imprimirEntreConNivel();

System.out.print ("Altura del arbol:");

System.out.println(abo.retornarAltura());

abo.mayorValorl();

abo.borrarMenor();

System.out.println("Luego de borrar el menor:");

abo.imprimirEntre ();

}

}
    

