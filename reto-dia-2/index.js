const calcular = () => {
  const importe = document.getElementById("cantidadHipoteca").value;
  const meses = document.getElementById("numeroCuotas").value;
  const interesAnual = document.getElementById("tipoInteres").value / 100;
  const interes = interesAnual / 12;

  const cuotaAPagar = document.querySelector("#cuotaMensual");

  console.log(importe);
  console.log(meses);  
  console.log(interesAnual);
  console.log(interes);
  
  let cuota = 0;


  if (interes == 0) {
    cuota = importe / meses;
  } else {
    cuota = (importe * interes) / (1  - (1 + interes) ** -meses);
  }  

  console.log(cuota.toFixed(2));

  cuotaAPagar.value = cuota.toFixed(2);
}

