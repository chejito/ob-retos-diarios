from calculadora import devolver_resultado


def calculadora():
    cadena_a_procesar = input("Introduce una operacion (Ejemplo: suma dos y tres):\n")
    resultado = devolver_resultado(cadena_a_procesar)
    print(resultado)


if __name__ == '__main__':
    calculadora()
