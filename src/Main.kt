// Función principal del programa
fun main() {
    // Inicializa una lista de enteros
    val hola = listOf(1,2,3,4,5)
    // Inicializa una cadena de texto
    val word = "ala"
    // Inicializa una lista de nombres masculinos
    val nombresMasculinos = listOf(
        "Alejandro",
        "Bruno",
        "Carlos",
        "David",
        "Eduardo",
        "Fernando",
        "Gabriel",
        "Hugo",
        "Iván",
        "Javier"
    )
    // Define una operación que suma dos enteros
    val operation:(Int, Int)-> Int = {x,y -> x+y}
    // Inicializa una lista de objetos Person
    val persons = listOf(
        createPerson("Alice", 30, "Female"),
        createPerson("Bob", 25, "Male"),
        createPerson("Charlie", 35, "Male")
    )
    // Inicializa una lista de IDs de estudiantes
    val studentIds = listOf("S123", "S456") // Menos IDs que personas para mostrar el manejo de valores predeterminados

    // Imprime el promedio de los números en la lista 'hola'
    println(calculateAverage(hola))
    // Imprime los números impares en la lista 'hola'
    println(oddNumbers(hola))
    // Imprime si la cadena 'word' es un palíndromo
    println(isPalindrome(word))
    // Imprime una bienvenida personalizada para cada nombre en 'nombresMasculinos'
    println(addWelcome(nombresMasculinos))
    // Imprime el resultado de aplicar la operación definida a los números 5 y 7
    println(calculateOperation(5,7,operation))
    // Convierte la lista de personas en una lista de estudiantes usando los IDs proporcionados
    val students = personsToStudents(persons, studentIds)
    // Imprime el nombre y la edad de cada estudiante
    students.forEach { student ->
        println("El Estudiante ${student.name} tiene ${student.age} años")
    }
}

// Calcula el promedio de una lista de números enteros
fun calculateAverage(numbers: List<Int>): Float {
    // Suma todos los números en la lista y convierte la suma a Float
    val sum = numbers.reduce { acc, num -> acc + num }.toFloat()
    // Devuelve el promedio
    return sum/numbers.size
}

// Filtra y devuelve solo los números impares de una lista
fun oddNumbers(numbers: List<Int>): List<Int> {
    return numbers.filter { num -> num % 2 != 0 }
}

// Verifica si una cadena de texto es un palíndromo
fun isPalindrome(word: String) = if(word == word.reversed()) true else false

// Añade un saludo personalizado a cada nombre en una lista
fun addWelcome(names: List<String>): List<String> {
    return names.map{"Hi $it you are very strong"}
}

// Realiza una operación definida (como suma) entre dos enteros
fun calculateOperation(a: Int, b: Int, operation: (Int, Int)->Int): Int {
    return operation(a, b)
}

// Crea un objeto Person con nombre, edad y género
fun createPerson(name: String, age: Int, gender: String): Person{
    return Person(name, age, gender)
}

// Convierte una lista de objetos Person a una lista de objetos Student, asignando IDs de estudiantes
fun personsToStudents(persons: List<Person>, studentsId: List<String>): List<Student> {
    return persons.mapIndexed { index, person ->
        Student(
            name = person.name,
            age = person.age,
            gender = person.gender,
            studentId = studentsId.getOrElse(index) { "Unknown" }
        )
    }
}
