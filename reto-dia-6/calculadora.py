import util as dno


def devolver_resultado(cadena_a_procesar):
    lista_a_procesar = cadena_a_procesar.split(" ")
    lista_limpia = limpiar_lista(lista_a_procesar)
    # print(lista_limpia)

    try:
        primera_operacion = lista_limpia[0]
        if not dno.lista_operaciones.__contains__(primera_operacion):
            raise KeyError
        primer_operando = dno.diccionario_numeros[lista_limpia[1]]
        segundo_operando = dno.diccionario_numeros[lista_limpia[2]]

        resultado = obtener_resultado(primer_operando, primera_operacion, segundo_operando)

        if type(resultado) == str:
            return resultado

        if len(lista_limpia) == 4 or len(lista_limpia) > 5:
            raise ValueError
        if len(lista_limpia) == 5:

            segunda_operacion = lista_limpia[3]
            if not dno.lista_operaciones.__contains__(segunda_operacion):
                raise KeyError
            tercer_operando = dno.diccionario_numeros[lista_limpia[4]]

            if segunda_operacion == "resta":
                resultado2 = obtener_resultado(tercer_operando, segunda_operacion, resultado)
            else:
                resultado2 = obtener_resultado(resultado, segunda_operacion, tercer_operando)

            if type(resultado2) == str:
                return resultado2

            resultado2_string = str(resultado2)
            resultado_texto2 = devolver_resultado_texto(resultado2_string)
            return "Resultado: " + resultado_texto2 + " (" + resultado2_string + ")"

        resultado_string = str(resultado)
        resultado_texto = devolver_resultado_texto(resultado_string)
        return "Resultado: " + resultado_texto + " (" + resultado_string + ")"
    except KeyError:
        palabras_clave = ', '.join(list(dno.diccionario_numeros.keys()))
        print("Error: Alguna palabra no está entre las palabras clave válidas")
        print("Palabras clave aceptadas: " + palabras_clave)
        return "No se ha realizado la operación"
    except IndexError:
        print("Error: Faltan palabras en la expresión para poder completar la operación")
        return "No se ha realizado la operación"
    except ValueError:
        print("Error: Demasiados operandos y/o pocas operaciones")
        return "No se ha realizado la operación"


def devolver_resultado_texto(resultado_string):
    resultado_texto = ""
    diccionario_num = dno.diccionario_numeros
    for numero in resultado_string:
        if numero == "-":
            resultado_texto += "menos"
        else:
            numero_entero = int(numero)
            resultado_texto += obtener_key(numero_entero, diccionario_num)
    return resultado_texto


def obtener_resultado(operando1, operacion, operando2):
    try:
        if operacion == "resta" or operacion == "restar" or operacion == "restale" or operacion == "réstale":
            resultado = operando2 - operando1
        else:
            if operacion == "suma" or operacion == "sumar" or operacion == "sumale" or operacion == "súmale":
                resultado = operando1 + operando2
            elif operacion == "multiplica" or "multiplicar" or operacion == "multiplicalo" or \
                    operacion == "multiplícalo":
                resultado = operando1 * operando2
            else:
                resultado = operando1 // operando2
        return resultado
    except KeyError:
        palabras_clave = ', '.join(list(dno.lista_operaciones))
        print("Error: Alguna palabra clave no está en la lista de operaciones:")
        print("Palabras clave aceptadas: " + palabras_clave)
        return "No se ha realizado la operación"


def limpiar_lista(lista_a_procesar):
    lista_a_devolver = []
    operaciones = dno.lista_operaciones
    numeros = dno.diccionario_numeros.keys()
    for palabra in lista_a_procesar:
        if operaciones.__contains__(palabra) or numeros.__contains__(palabra):
            lista_a_devolver.append(palabra)
    return lista_a_devolver


def obtener_key(valor, diccionario):
    for key, value in diccionario.items():
        if valor == value:
            return key

    return "Clave no existe"
