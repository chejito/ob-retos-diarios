from calculadora import devolver_resultado


def calculadora():
    cadena_a_procesar = input("Introduce una operación mediante texto y numeros del 0 al 9"
                              "\nEjemplos: \n- 'suma dos y tres'\n- 'resta tres de seis y multiplícalo por cinco'"
                              "\no pulsa Enter para salir:\n")
    while cadena_a_procesar != "":
        resultado = devolver_resultado(cadena_a_procesar)
        print(resultado)
        cadena_a_procesar = input("Introduce una operacion o pulsa enter para salir:\n")


if __name__ == '__main__':
    calculadora()
