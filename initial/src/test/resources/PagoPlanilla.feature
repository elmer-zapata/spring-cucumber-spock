  Feature: Pago con descuento utilizando tarjeta de debito
    As a cliente planilla
    I want pagar con descuento utilizando tarjeta de debito
    So that me beneficie con un descuento en un comercio asociado

    Scenario Outline: Un cliente paga con tarjeta de debito en comercio
      Given estoy en un comercio <tipo_comercio>
      And soy un cliente <tipo_cliente> con tarjeta numero <numero_tarjeta> asociado a una cuenta en <moneda_de_cuenta>
      And mi consumo tiene un 20 porciento de descuento registrado
      When el comercio introduce el importe de consumo de <importe_sin_descuento> <moneda>
      Then el importe con descuento por el beneficio es <importe_con_descuento> <moneda>
      Examples:
        | tipo_comercio | tipo_cliente | numero_tarjeta | moneda_de_cuenta | importe_sin_descuento | moneda | importe_con_descuento |
        | asociado      | planilla     | xxx            | bs               | 100                   | bs     | 80                    |
        | noAsociado    | noPlanilla   | xxx            | bs               | 100                   | bs     | 100                   |
        | asociado      | planilla     | yyy            | bs               | 100                   | bs     | 100                   |
        | noAsociado    | noPlanilla   | yyy            | bs               | 100                   | bs     | 100                   |


  Feature: Pago con descuento utilizando tarjeta de debito
    As a cliente planilla
    I want pagar con descuento utilizando tarjeta de debito
    So that me beneficie con un descuento en un comercio asociado

    Scenario: Un cliente paga con tarjeta de debito en comercio
      Given estoy en un comercio asociado
      And soy un cliente planilla con tarjeta numero xxx asociado a una cuenta en bs
      And mi consumo tiene un 20 porciento de descuento registrado
      When el comercio introduce el importe de consumo de 100 bs
      Then el importe con descuento por el beneficio es 80 bs

  Feature: Pago con descuento utilizando tarjeta de debito
    As a cliente no  planilla
    I want pagar con descuento utilizando tarjeta de debito
    So that no me beneficie con un descuento en un comercio asociado

    Scenario: Un cliente paga con tarjeta de debito en comercio
      Given estoy en un comercio asociado
      And soy un cliente no  planilla con tarjeta numero xxx asociado a una cuenta en bs
      And mi consumo tiene un 0 porciento de descuento registrado
      When el comercio introduce el importe de consumo de 100 bs
      Then el importe con descuento por el beneficio es 0 bs