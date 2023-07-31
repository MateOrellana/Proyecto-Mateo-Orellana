# Universidad Politécnica Salesiana
- Nombre: Mateo Sebastian Orellana Flores
- Carrera: Computación

### Estructura de Datos
- Arboles Binarios
- Diccionarios con HashMap

# Sistema de Gestión de Contactos

El proyecto es un programa de gestión de una lista de contactos telefónicos implementado en Java. Utiliza un árbol binario de búsqueda para organizar los contactos de forma ordenada según su nombre. Cada contacto tiene un nombre, un número de teléfono, una colección de correos y un diccionario que almacena las redes sociales del contacto.

El programa proporciona un menú de opciones que permite al usuario agregar, buscar y eliminar contactos, así como agregar correos y redes sociales a los contactos existentes. También ofrece métodos para realizar diferentes recorridos del árbol (preorder, inorder, postorder y achura) y obtener información sobre el número total de contactos y el número de niveles del árbol.
## Estructura del proyecto

El proyecto está organizado en las siguientes clases:

### Clase "Contacto"
La clase "Contacto" representa un contacto telefónico y contiene los siguientes atributos:

- `nombre`: String que almacena el nombre del contacto.
- `telefono`: String que almacena el número de teléfono del contacto.
- `correos`: Colección de Strings que almacena los correos electrónicos asociados al contacto.
- `redesSociales`: Diccionario (Map) que almacena las redes sociales asociadas al contacto, donde la clave es el nombre de la red social y el valor es la URL del perfil del contacto en dicha red.

La clase también proporciona métodos para agregar correos y redes sociales, así como getters y setters para acceder a los atributos del contacto.

### Clase "Nodo"
La clase "Nodo" representa un nodo del árbol binario de búsqueda y contiene los siguientes atributos:

- `contacto`: Objeto de la clase "Contacto" que almacena la información del contacto asociado al nodo.
- `izquierdo`: Referencia al nodo hijo izquierdo.
- `derecho`: Referencia al nodo hijo derecho.

La clase no proporciona setters para los atributos `izquierdo` y `derecho`, ya que estos se modifican a través de métodos específicos para mantener la estructura del árbol.

### Clase "ArbolContactos"
La clase "ArbolContactos" representa el árbol binario de búsqueda y contiene los siguientes atributos:

- `raiz`: Referencia al nodo raíz del árbol.

La clase proporciona métodos para agregar, buscar y eliminar contactos, así como para agregar correos y redes sociales a los contactos existentes. También implementa los métodos de recorrido del árbol (preorder, inorder, postorder y achura) y métodos para obtener información sobre el número total de contactos y el número de niveles del árbol.

## Métodos del proyecto
### Método `recorridoPreorder()`
Este método realiza el recorrido preorder del árbol binario de búsqueda. En el recorrido preorder, se visita primero el nodo raíz, luego los nodos hijos izquierdos y finalmente los nodos hijos derechos.

Explicación:
- El método recorridoPreorder() es un método público que actúa como el punto de entrada para el recorrido preorder del árbol. Llama al método privado recorridoPreorderRec() y le pasa la raíz del árbol como punto de inicio del recorrido.
- El método recorridoPreorderRec() es un método privado que realiza el recorrido preorder de forma recursiva. Imprime el contacto del nodo actual, luego se llama a sí mismo con el nodo hijo izquierdo del nodo actual para recorrer todos los nodos hijos izquierdos y, finalmente, se llama a sí mismo con el nodo hijo derecho del nodo actual para recorrer todos los nodos hijos derechos.

El resultado del recorrido preorder será una lista de contactos que muestra primero el nodo raíz, seguido de todos los nodos hijos izquierdos y, finalmente, todos los nodos hijos derechos.

### Método `recorridoInorder()`
Este método realiza el recorrido inorder del árbol binario de búsqueda. En el recorrido inorder, se visitan primero los nodos hijos izquierdos, luego el nodo raíz y finalmente los nodos hijos derechos. Este recorrido produce una lista ordenada de los elementos del árbol en orden ascendente según su clave (en este caso, el nombre del contacto).

Explicación:
- El método recorridoInorder() es un método público que actúa como el punto de entrada para el recorrido inorder del árbol. Llama al método privado recorridoInorderRec() y le pasa la raíz del árbol como punto de inicio del recorrido.
- El método recorridoInorderRec() es un método privado que realiza el recorrido inorder de forma recursiva. Se llama a sí mismo con el nodo hijo izquierdo del nodo actual como parámetro para recorrer todos los nodos hijos izquierdos. Luego imprime el contacto del nodo actual y, finalmente, se llama a sí mismo con el nodo hijo derecho del nodo actual para recorrer todos los nodos hijos derechos.

El resultado del recorrido inorder será una lista ordenada de los contactos almacenados en el árbol, según el orden alfabético de sus nombres. Este método aprovecha la propiedad del árbol binario de búsqueda, donde los nodos hijos izquierdos tienen claves menores y los nodos hijos derechos tienen claves mayores que la clave del nodo actual. Por lo tanto, el recorrido inorder garantiza que los elementos se muestren en orden ascendente.

### Método `recorridoPostorder()`
Este método realiza el recorrido postorder del árbol binario de búsqueda. En el recorrido postorder, se visitan primero los nodos hijos izquierdos, luego los nodos hijos derechos y finalmente el nodo raíz.

Explicación:
- El método recorridoPostorder() es un método público que actúa como el punto de entrada para el recorrido postorder del árbol. Llama al método privado recorridoPostorderRec() y le pasa la raíz del árbol como punto de inicio del recorrido.
- El método recorridoPostorderRec() es un método privado que realiza el recorrido postorder de forma recursiva. Se llama a sí mismo con el nodo hijo izquierdo del nodo actual para recorrer todos los nodos hijos izquierdos, luego se llama a sí mismo con el nodo hijo derecho del nodo actual para recorrer todos los nodos hijos derechos y, finalmente, imprime el contacto del nodo actual.

El resultado del recorrido postorder será una lista de contactos que muestra primero todos los nodos hijos izquierdos, seguido de todos los nodos hijos derechos y, finalmente, el nodo raíz.

### Método `recorridoAchura()`
Este método realiza el recorrido por amplitud (achura) del árbol binario de búsqueda. En el recorrido por amplitud, se visitan todos los nodos nivel por nivel, comenzando por el nodo raíz.

Explicación:
- El método recorridoAchura() utiliza una cola para realizar el recorrido por amplitud del árbol. Se crea una cola y se agrega la raíz del árbol si existe.
- Luego, se inicia un bucle while que se ejecuta mientras la cola no esté vacía. En cada iteración, se toma el primer nodo de la cola (el nodo raíz o el primer nodo agregado en el nivel actual) y se imprime su contacto.
- A continuación, se revisan los hijos izquierdo y derecho del nodo actual. Si existen, se agregan a la cola para que se visiten en el siguiente nivel del recorrido.

El resultado del recorrido por amplitud será una lista de contactos que muestra los nodos nivel por nivel, comenzando por la raíz y continuando con los nodos hijos en cada nivel en orden de izquierda a derecha.

## Explicación de Diccionarios y HashMap

### Diccionarios

Los diccionarios son estructuras de datos que almacenan pares clave-valor, donde cada clave es única y se utiliza para acceder a su correspondiente valor. En este proyecto, la clase `HashMap` de Java se considera un diccionario, ya que almacena elementos en forma de pares clave-valor.

### HashMap

La clase `HashMap` en Java es una implementación de la interfaz `Map`, que proporciona una estructura de datos basada en tablas hash. Permite almacenar y acceder eficientemente a elementos utilizando claves únicas. En el contexto de este proyecto, se utiliza un `HashMap` para asociar el nombre de un contacto con su instancia correspondiente.





---

### JSON: Estructura de Datos en Formato Clave-Valor

**JSON** (JavaScript Object Notation) no es considerado un diccionario en sí mismo, sino un formato de intercambio de datos. Sin embargo, la estructura de un objeto JSON se asemeja a un diccionario en algunos aspectos.

En **JSON**, los datos se representan en **pares clave-valor**, donde cada clave es única y se utiliza para acceder a su correspondiente valor. Esto se asemeja a la estructura de un diccionario, donde cada elemento se identifica por una clave y contiene un valor asociado.

En muchos lenguajes de programación, es común utilizar estructuras de datos como **diccionarios** o **mapas** para almacenar y manipular objetos JSON. Estas estructuras permiten acceder a los valores mediante las claves y proporcionan métodos para agregar, modificar y eliminar elementos.

JSON en sí mismo no es un diccionario, pero su estructura de pares clave-valor se asemeja a la de un diccionario y puede ser representado y manipulado utilizando estructuras de datos similares.
