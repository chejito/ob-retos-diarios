import pandas as pd

# Seleccionamos el archivo a procesar y la hoja
file_name = "files/emails.xlsx"
sheet = "Hoja1"

# Creamos un archivo dataframe de la columna email
emails = pd.read_excel(io=file_name, sheet_name=sheet, usecols=["email"])

# Convertimos ese archivo a una lista
emailList = list(emails["email"])

# Convertimos la lista a un set para eliminar los elementos repetidos
emailSet = set(emailList)

print("""
E-mails sin repetir:
--------------------""")
for email in emailSet:
    print(email)
