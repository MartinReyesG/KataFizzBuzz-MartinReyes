import java.math.BigDecimal
fun main() {

    imprimirResultado() //metodo que va a devolver el resutado dependiendo del numero que se ingrese
}

fun imprimirResultado(){
    print("Ingrese un numero: ")
    var numero = readLine()!!.toInt() //lee el número y se asigna a la variable número
    //   println(numero)

    if (numero >= 0 && numero <= 1000000) { //verifica que este en un rango de 0 a 1000000
        if (numero%15==0) //Si el número es múltiplo de 15 imprime FizzBuzz!
        {
            println("FizzBuzz!")
        }else if (numero%3==0) //Si el número es múltiplo de 3 imprime Buzz!
        {
            println("Buzz!")
        } else if (numero%5==0) //Si el número es múltiplo de 5 imprime "Fizz!
        {
            println("Fizz!");
        }
        else
        {//caso de que no sea ninguno de los casos anteriores (multiplos del 3, 5 o 15)
            println(parseadaDeNumeros(numero.toString())) //manda a llamar a la funcion que convierte el numero a texto
                                                            //donde se le manda como paramentro el numero en cadena
        }
    } else { //Este caso es cuando el numero no esta dentro del rango de 0 a 1000000
        println("Número fuera del rango")
    }
}

fun parseadaDeNumeros(cadena: String?): String? { //tiene como parametro el numero que insertamos y regresa una cadena
    val cadenaFinal = StringBuilder() //Sirve para crer un objeto que almacena una cadena sin que tenga que crear un nuevo objeto
    val cantidadTotal = BigDecimal(cadena).setScale(2, BigDecimal.ROUND_DOWN) //traduce un cadena a bigDecimal
                                                                            //en donde se especifica la escala de redondeo a 2
    val parteEntera = cantidadTotal.toBigInteger().toLong() //el valor de la cantidadTotal se convierte de bigDecimal a BigInt
    val tresUnidades = (parteEntera % 1000).toInt() //Guardamos la cantidad de numeros si es que el numero introducido
                                                    //tiene tres y se convierte en Int
    val miles = (parteEntera / 1000 % 1000).toInt() //Guardamos la cantidad de numeros si es que el numero introducido
                                                //tiene miles y se convierte en Int
    val millones = (parteEntera / 1000000 % 1000).toInt()//Guardamos la cantidad de numeros si es que el numero introducido
                                                 //tiene millones y se convierte en Int
    val milMillones = (parteEntera / 1000000000 % 1000).toInt()//Guardamos la cantidad de numeros si es que el numero introducido
                                                //tiene milMillones y se convierte en Int
    if (milMillones > 0) cadenaFinal.append(numeroDeTres(milMillones).toString() + "Mil ") //si la variable mill millones es mayor a 0
                //entonces se va a inserta lo que nos regrese el método numeroDeTres donde mandamos milMillones para verificar cuantos
                //numeros de esa cantidad tenemos, adjuntanso la cadena mill al final
    if (millones > 0) cadenaFinal.append(numeroDeTres(millones).toString())//si la variable  millones es mayor a 0
    //entonces se va a inserta lo que nos regrese el método numeroDeTres donde mandamos millones para verificar cuantos
    //numeros de esa cantidad tenemos
    if (milMillones == 0 && millones == 1) cadenaFinal.append("Millón ") else if (milMillones > 0 || milMillones > 0) cadenaFinal.append(
        "Millones "
    //En este punto vamos a refiricar si ya no tenemos milMillones y que al menos nos haga falta un millon para de esta manera
    //insertar la palabra millon. Si es que no es asi, entonces se verifica si millMillones es mayor a 0 (que todavia hay) o que MillMillones
    //todavia tenga, si es asi se adjunta la palabra millones porque todavia nos quedan
    )
    if (miles > 0) cadenaFinal.append(numeroDeTres(miles).toString() + "Mil ") //realizamos el proceso anterior,
            //solo que con miles ademas de verificar cuantos numeros de miles hay en existencia
    if (tresUnidades > 0) cadenaFinal.append(numeroDeTres(tresUnidades).toString())
    return cadenaFinal.toString() //se regresa la cadena final y terminada
}

//Se encarga de determianr la cantidad de digitos de una cierta cantidad de numeros
private fun numeroDeTres(n: Int): StringBuilder {
    val result = StringBuilder()
    val centenas = n / 100 //divide la cantidad de centenas
    val decenas = n % 100 / 10 //divide la cantidad de decenas
    val unidades = n % 10 //divide la cantidad de unidades
    when (centenas) {
        0 -> {} //si centenas es igual a 0 entonces no hace nada y pasa al sigueiente
        1 -> if (decenas == 0 && unidades == 0) { //si se cumple es que la palabra solo va a llevar 100 (1 digito)
            result.append("Cien ")
            return result //regresa 100
        } else result.append("Ciento ") //cantidad para una de los siguientes casos desde el 2 al 9
        2 -> result.append("Doscientos ")
        3 -> result.append("Trescientos ")
        4 -> result.append("Cuatrocientos ")
        5 -> result.append("Quinientos ")
        6 -> result.append("Seiscientos ")
        7 -> result.append("Setecientos ")
        8 -> result.append("Ochocientos ")
        9 -> result.append("Novecientos ")
    }
    when (decenas) { //mismo proceso que en el paso anterior pero con las decenas
        0 -> {}
        1 -> if (unidades == 0) {
            result.append("Diez ")
            return result
        } else if (unidades == 1) {
            result.append("Once ")
            return result
        } else if (unidades == 2) {
            result.append("Doce ")
            return result
        } else if (unidades == 3) {
            result.append("Trece ")
            return result
        } else if (unidades == 4) {
            result.append("Catorce ")
            return result
        } else if (unidades == 5) {
            result.append("Quince ")
            return result
        } else result.append("Dieci")
        2 -> if (unidades == 0) {
            result.append("Veinte ")
            return result
        } else result.append("Veinti")
        3 -> result.append("Treinta ")
        4 -> result.append("Cuarenta ")
        5 -> result.append("Cincuenta ")
        6 -> result.append("Sesenta ")
        7 -> result.append("Setenta ")
        8 -> result.append("Ochenta ")
        9 -> result.append("Noventa ")
    }
    if (decenas > 2 && unidades > 0) result.append("y ") //es para verificar si es que hay mas de dos decenas o
                                                    //si hay mas de 0 unidades porque si por ejemplo, hubiera 1 decena,
                                                    //la gramatica ya cambiaria
    when (unidades) {
        0 -> {}
        1 -> result.append("Un ") //se adjunta la cadena segun el caso correspondiente
        2 -> result.append("Dos ")
        3 -> result.append("Tres ")
        4 -> result.append("Cuatro ")
        5 -> result.append("Cinco ")
        6 -> result.append("Seis ")
        7 -> result.append("Siete ")
        8 -> result.append("Ocho ")
        9 -> result.append("Nueve ")
    }
    return result //se regresa el resultado
}