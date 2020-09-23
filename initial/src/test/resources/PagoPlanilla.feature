Feature: Recibir informacion de descuentos al tener un pago con tarjeta
  de un cliente del banco BISA en comercios que estan y no estan afiliados al pago planilla

  @Integration @Positive
  Scenario: Realizar un pago a un comercio afiliado y recibir descuento
    Given un cliente con el beneficio descuento pago planilla y numero de tarjeta 123456
    When hace el pago de 100 bolivianos al comercio SUPERMERCADO que tiene 20% de descuento
    Then espera recibir el descuento de 20 bolivianos

  @Integration @Negative
  Scenario: Realizar un pago a un comercio afiliado sin recibir descuento
    Given un cliente sin el beneficio descuento pago planilla y numero de tarjeta 123456
    When hace el pago de 100 bolivianos al comercio SUPERMERCADO que tiene 20% de descuento
    Then espera recibir el monto del descuento de 0 bolivianos

  @Integration @Negative
  Scenario: Realizar un pago a un comercio no afiliado y no recibir descuento
    Given un cliente con el beneficio descuento pago planilla y numero de tarjeta 123456
    When hace el pago de 100 bolivianos al comercio FARMACIA que tiene 0% de descuento
    Then espera recibir el descuento de 0 bolivianos

  @Integration @Negative
  Scenario: Realizar un pago a un comercio no afiliado y no recibir descuento
    Given un cliente sin el beneficio descuento pago planilla y numero de tarjeta 123456
    When hace el pago de 100 bolivianos al comercio FARMACIA que tiene 0% de descuento
    Then espera recibir el monto del descuento de 0 bolivianos

  @Integration @Negative
  Scenario: Realizar un pago a un comercio afiliado sin fondos suficientes
    Given un cliente con el beneficio descuento pago planilla y numero de tarjeta 123456
    When el cliente intenta pagar con fondos insuficientes al comercio SUPERMERCADO que tiene 20% de descuento
    Then una excepcion de fondos insuficientes es lanzada