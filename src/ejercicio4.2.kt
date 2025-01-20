class Persona( val peso: Double, var altura: Double, val nombre: String? = null) {
    val imc: Double
        get() = peso / (altura * altura)

    override fun toString(): String {
        return "Nombre: ${nombre ?: "Sin nombre"}, Peso: $peso kg, Altura: $altura m, IMC: ${"%.2f".format(imc)}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false

        return peso == other.peso && altura == other.altura && nombre == other.nombre
    }

    override fun hashCode(): Int {
        var result = peso.hashCode()
        result = 31 * result + altura.hashCode()
        result = 31 * result + (nombre?.hashCode() ?: 0)
        return result
    }
}

fun main() {
    // Crear personas
    val persona1 = Persona(70.0, 1.75)
    val persona2 = Persona(60.0, 1.65, "Ana")
    val persona3 = Persona(80.0, 1.90, "Carlos")

    println(persona1)
    println(persona2)
    println(persona3)


    print("Introduce el nombre para la persona 1: ")
    val nuevoNombre = readlnOrNull()?.takeIf { it.isNotBlank() } ?: throw IllegalArgumentException("El nombre no puede ser vacío o nulo.")
    val persona1ConNombre = Persona(persona1.peso, persona1.altura, nuevoNombre)


    println("\nPersona 1 - Nombre: ${persona1ConNombre.nombre}, Peso: ${persona1ConNombre.peso} kg, Altura: ${persona1ConNombre.altura} m")


    println("\nPersona 3 - Peso: ${persona3.peso} kg, Altura: ${persona3.altura} m, IMC: ${"%.2f".format(persona3.imc)}")


    val persona3ConNuevaAltura = Persona(persona3.peso, 1.80, persona3.nombre)
    println("\nPersona 3 (modificada) - Peso: ${persona3ConNuevaAltura.peso} kg, Altura: ${persona3ConNuevaAltura.altura} m, IMC: ${"%.2f".format(persona3ConNuevaAltura.imc)}")


    val persona2ConNuevaAltura = Persona(persona2.peso, persona3ConNuevaAltura.altura, persona2.nombre)


    println("\nPersona 2: $persona2ConNuevaAltura")
    println("Persona 3: $persona3ConNuevaAltura")


    val sonIguales = persona2ConNuevaAltura == persona3ConNuevaAltura
    println("\n¿Persona 2 y Persona 3 son iguales? $sonIguales")
}
