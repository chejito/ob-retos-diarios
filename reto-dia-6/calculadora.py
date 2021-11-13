import util as dno


def devolver_resultado(cadena_a_procesar):
    lista_a_procesar = cadena_a_procesar.split(" ")
    lista_limpia = limpiar_lista(lista_a_procesar)

    try:
        primera_operacion = lista_limpia[0]
        primer_operando = dno.diccionario_numeros[lista_limpia[1]]
        segundo_operando = dno.diccionario_numeros[lista_limpia[2]]

        resultado = obtener_resultado(primer_operando, primera_operacion, segundo_operando)

        if type(resultado) == str:
            return resultado

        if len(lista_limpia) == 5:
            segunda_operacion = lista_limpia[3]
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


def devolver_resultado_texto(resultado_string):
    resultado_texto = ""
    diccionario_num = dno.diccionario_numeros
    for numero in resultado_string:
        numero_entero = int(numero)
        resultado_texto += obtener_key(numero_entero, diccionario_num)
    return resultado_texto


def obtener_resultado(operando1, operacion, operando2):
    try:
        if operacion == "resta" or operacion == "restale" or operacion == "réstale":
            resultado = operando2 - operando1
        else:
            if operacion == "suma" or operacion == "sumale" or operacion == "súmale":
                resultado = operando1 + operando2
            elif operacion == "multiplica" or operacion == "multiplicalo" or operacion == "multiplícalo":
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
    for palabra in lista_a_procesar:
        if dno.lista_conjunciones.__contains__(palabra):
            continue
        lista_a_devolver.append(palabra)
    return lista_a_devolver


def obtener_key(valor, diccionario):
    for key, value in diccionario.items():
        if valor == value:
            return key

    return "Clave no existe"