import kotlin.random.Random

/*
Desarrolla un programa con las siguientes clases:

- Clase Cafetera con atributos ubicacion (nombre de la sala o habitación dónde se encuentra), capacidad (la cantidad máxima de café que puede contener la cafetera) y cantidad (la cantidad actual de café
que hay en la cafetera).
Implementa, al menos, los siguientes métodos:
    * En la clase se debe establecer la capacidad máxima en 1000 (c.c.) y la actual en cero (cafetera vacía).
    * Constructor primario con la ubicacion.
    * Constructor secundario con la ubicación y la capacidad máxima de la cafetera. Inicializa la cantidad actual de café igual a la capacidad máxima.
    * Constructor secundario con la ubicacion, la capacidad máxima y la cantidad actual. Si la cantidad actual es mayor que la capacidad máxima de la cafetera, la ajustará al máximo.
    * llenar(): hace que la cantidad actual sea igual a la capacidad.
    * servirTaza(Taza): simula la acción de servir una taza con la capacidad que tenga la taza. Si la cafetera tiene café, llenará la taza y restará la cantidad servida en la cantidad de la cafetera. Si la cantidad actual de café “no alcanza” para llenar la taza, se sirve lo que quede. Actualizar la cantidad de la cafetera y aplicar el método adecuado de la taza.
    * vaciar(): pone la cantidad de café actual en cero.
    * agregarCafe(Int): añade a la cafetera la cantidad de café indicada. Por defecto añade 200 c.c. No se puede añadir más cantidad que su capacidad máxima, si ocurriera esta circunstancia, simplemente llenaríamos la cantidad de la cafetera a su capacidad máxima.
    * toString(): debe retornar por ejemplo "Cafetera(ubicación = Salón, capacidad = 1000 c.c., cantidad = 0 c.c.)"

- Clase Taza, que tendrá los atributos color, capacidad y cantidad.
Implementa, al menos, los siguientes métodos:
    * Un único constructor con el color (por defecto blanco) y la capacidad (por defecto 50 c.c.). La clase también contendrá un atributo con la cantidad que se establcerá a 0.
    * La propiedad cantidad debe modificarse para que si el valor que recibe es mayor que la capacidad de la taza, solo establezca el valor de dicha capacidad.
    * El método llenar() que establecerá la cantidad de la taza a su máxima capacidad.
    * El método "sobrecargado" llenar(Int) que establecerá la cantidad de la taza a la cantidad pasada como argumento al método.
    * Sobreescribir el método toString(), que debe retornar por ejemplo "Taza(color = BLANCO, capacidad = 50 c.c., cantidad = 30 c.c.)"

- Clase enumerada Color, que contendrá los colores disponibles: blanco, negro, gris, azul y verde.

En el programa principal se deben crear 3 cafeteras de capacidad 1000, 750 y 500 c.c. con 0, 750 y 200 c.c de cantidad respectivamente. Para crear cada cafetera, debéis utilizar un constructor diferente.
También debéis generar una lista de 20 tazas con la capacidad de 50, 75 y 100 de manear aleatoria.
*/

/**
 * Crea y devuelve una lista de 20 tazas con capacidades aleatorias (50, 75 o 100 c.c.).
 * Los colores de las tazas son seleccionados aleatoriamente de entre los colores disponibles.
 * @return Lista de tazas generadas.
 */
fun crearListaTazas() : List<Taza> {
    val tazas = mutableListOf<Taza>()

    for (i in 1..20) {
        val capacidadAleatoria = when (Random.nextInt(3)) {
            0 -> 50
            1 -> 75
            else -> 100
        }
        val taza = Taza(Color.entries.toTypedArray().random(), capacidadAleatoria)
        tazas.add(taza)
    }

    return tazas.toList()
}

/**
 * Simula la acción de servir cada taza en la lista utilizando las cafeteras proporcionadas.
 * Las tazas se sirven una por una, y se utiliza la primera cafetera disponible.
 * @param tazas Lista de tazas a servir.
 * @param cafeteras Lista de cafeteras disponibles para servir.
 */
fun servirTazas(tazas: List<Taza>, cafeteras: List<Cafetera>) {
    for (taza in tazas) {
        for (cafetera in cafeteras) {
            if (cafetera.cantidad > 0) {
                cafetera.servirTaza(taza)
                //Si se utilizó una cafetera, salimos del bucle for porque ya sirvió la taza
                break
            }
        }
    }
}

/**
 * Muestra la información de las tazas y las cafeteras proporcionadas.
 * @param tazas Lista de tazas a mostrar.
 * @param cafeteras Lista de cafeteras a mostrar.
 */
fun mostrarInfo(tazas: List<Taza>, cafeteras: List<Cafetera>) {
    mostrarCafeteras(cafeteras)
    mostrarTazas(tazas)
}

/**
 * Muestra la información de cada taza en la lista.
 * @param tazas Lista de tazas a mostrar.
 */
fun mostrarTazas(tazas: List<Taza>) {
    for (taza in tazas) {
        println(taza)
    }
}

/**
 * Muestra la información de cada cafetera en la lista.
 * @param cafeteras Lista de cafeteras a mostrar.
 */
fun mostrarCafeteras(cafeteras: List<Cafetera>) {
    for (cafetera in cafeteras) {
        println(cafetera)
    }
}

fun main() {

    //TODO: Crear 3 cafeteras en la Sala, Cocina y Oficina
    val cafetera1 = Cafetera("Sala")
    val cafetera2 = Cafetera("Cocina", 750)
    val cafetera3 = Cafetera("Oficina", 500, 200)

    val cafeteras = listOf(cafetera1, cafetera2, cafetera3)

    //TODO: Crear una lista de 20 tazas con capacidades aleatorias
    val tazas = crearListaTazas()

    //TODO: Mostrar por pantalla el contenido de las 3 cafeteras y las tazas.
    println("**********************************************")
    mostrarInfo(tazas, listOf(cafetera1, cafetera2, cafetera3))

    println("**********************************************")
    println("Llenar la cafetera1 de café...")
    println("Vaciar la cafetera2...")
    println("Agregar café a la cafetera2 a la mitad de su capacidad...")
    println("Agregar 400 c.c. de café a la cafereta3...")

    //TODO: Llenar la cafetera1 de café.
    cafetera1.llenar()

    //TODO: Vaciar la cafetera2.
    cafetera2.vaciar()
    //TODO: Agregar café a la cafetera2 a la mitad de su capacidad.
    cafetera2.agregarCafe(cafetera2.capacidad / 2)

    //TODO: Agregar 400 c.c. de café a la cafereta3
    cafetera3.agregarCafe(400)

    //TODO: Mostrar por pantalla el contenido de las 3 cafeteras
    println("**********************************************")
    mostrarCafeteras(cafeteras)

    println("**********************************************")
    println("Servir café en las tazas...")

    //TODO: Servir café en las tazas... siempre que haya café en la cafetera y en el orden cafetera1, cafetera2 y cafetera3.
    servirTazas(tazas, cafeteras)
    /*
    for (taza in tazas) {
        if (cafetera1.cantidad > 0) {
            cafetera1.servirTaza(taza)
        }
        else if (cafetera2.cantidad > 0) {
            cafetera2.servirTaza(taza)
        }
        else {
            cafetera3.servirTaza(taza)
        }
    }*/

    //TODO: Mostrar por pantalla el contenido de las 3 cafeteras y las tazas.
    println("**********************************************")
    mostrarInfo(tazas, cafeteras)

}

/**
 * Clase que representa una cafetera con atributos como ubicación, capacidad y cantidad de café.
 * La capacidad máxima por defecto es 1000 c.c. y la cantidad inicial por defecto es 0 (cafetera vacía).
 * @param ubicacion Nombre de la sala o habitación donde se encuentra la cafetera.
 */
class Cafetera(val ubicacion: String) {

    var capacidad: Int = 1000
    var cantidad: Int = 0

    /**
     * Constructor secundario que permite especificar la capacidad máxima de la cafetera al crearla.
     * @param ubicacion Nombre de la sala o habitación donde se encuentra la cafetera.
     * @param capacidad Capacidad máxima de la cafetera en c.c.
     */
    constructor(ubicacion: String, capacidad: Int) : this(ubicacion) {
        this.capacidad = capacidad
        this.cantidad = capacidad
    }

    /**
     * Constructor secundario que permite especificar la capacidad máxima y la cantidad inicial de la cafetera.
     * Ajusta la cantidad inicial al máximo si es mayor que la capacidad máxima.
     * @param ubicacion Nombre de la sala o habitación donde se encuentra la cafetera.
     * @param capacidad Capacidad máxima de la cafetera en c.c.
     * @param cantidad Cantidad inicial de café en la cafetera en c.c.
     */
    constructor(ubicacion: String, capacidad: Int, cantidad: Int) : this(ubicacion) {
        this.capacidad = capacidad
        this.cantidad = if (cantidad > capacidad) capacidad else cantidad
    }

    /**
     * Llena la cafetera estableciendo la cantidad actual igual a la capacidad máxima.
     */
    fun llenar() {
        this.cantidad = this.capacidad
    }

    /**
     * Simula la acción de servir una cantidad específica de café de la cafetera.
     * Resta la cantidad servida de la cantidad actual de café en la cafetera.
     * @param cantidad Cantidad de café a servir.
     */
    fun servirCafe(cantidad: Int) {
        this.cantidad -= cantidad
    }

    /**
     * Simula la acción de servir una taza con la capacidad que tenga la taza.
     * Si la cafetera tiene café, llenará la taza y restará la cantidad servida en la cantidad de la cafetera.
     * Si la cantidad actual de café "no alcanza" para llenar la taza, se sirve lo que quede.
     * Actualiza la cantidad de la cafetera y aplica el método adecuado de la taza.
     * @param taza Taza a la que se va a servir café.
     */
    fun servirTaza(taza: Taza) {
        if (this.cantidad > 0) {
            if (this.cantidad > taza.capacidad) {
                taza.llenar()
                servirCafe(taza.capacidad)
            } else {
                taza.llenar(this.cantidad)
                vaciar()
            }
        }
    }

    /**
     * Pone la cantidad de café actual en cero.
     */
    fun vaciar() {
        this.cantidad = 0
    }

    /**
     * Añade a la cafetera la cantidad de café indicada. Por defecto, añade 50 c.c.
     * Si la cantidad sumada es igual a la capacidad máxima o excede la capacidad, llena la cafetera.
     * @param cantidad Cantidad de café a agregar (por defecto 50 c.c.).
     */
    fun agregarCafe(cantidad: Int = 200) {
        if (cantidad == this.capacidad || this.cantidad + cantidad > this.capacidad) {
            llenar()
        }
        else {
            this.cantidad = cantidad
        }
    }

    /**
     * Representación textual de la cafetera en formato de cadena.
     * @return Cadena que describe la cafetera con su ubicación, capacidad y cantidad.
     */
    override fun toString(): String {
        return "Cafetera(ubicación = ${this.ubicacion}, capacidad = ${this.capacidad} c.c., cantidad = ${this.cantidad} c.c.)"
    }
}

/**
 * Clase enumerada que contiene los colores disponibles para una taza.
 */
enum class Color {
    BLANCO, NEGRO, GRIS, AZUL, VERDE
}

/**
 * Clase que representa una taza con atributos como color, capacidad y cantidad de líquido.
 * El color por defecto es blanco y la capacidad por defecto es 50 c.c. La cantidad se establece inicialmente en 0.
 * @param color Color de la taza (por defecto blanco).
 * @param capacidad Capacidad de la taza en c.c. (por defecto 50).
 */
class Taza(val color: Color = Color.BLANCO, val capacidad: Int = 50) {

    /**
     * Cantidad de líquido actual en la taza.
     * Si el valor que recibe es mayor que la capacidad de la taza, solo establece el valor de dicha capacidad.
     */
    var cantidad = 0
        set(value) {
            field = if (value > this.capacidad) this.capacidad else value
        }

    /**
     * Llena la taza estableciendo la cantidad igual a su capacidad máxima.
     */
    fun llenar() {
        this.cantidad = this.capacidad
    }

    /**
     * Llena la taza estableciendo la cantidad según el valor pasado como argumento.
     * @param cantidad Cantidad de líquido con la que se llenará la taza.
     */
    fun llenar(cantidad: Int) {
        this.cantidad = cantidad
    }

    /**
     * Representación textual de la taza en formato de cadena.
     * @return Cadena que describe la taza con su color, capacidad y cantidad.
     */
    override fun toString(): String {
        return "Taza(color = ${this.color}, capacidad = ${this.capacidad} c.c., cantidad = ${this.cantidad} c.c.)"
    }
}