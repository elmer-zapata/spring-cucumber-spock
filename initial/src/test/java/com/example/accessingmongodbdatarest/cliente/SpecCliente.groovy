package com.example.accessingmongodbdatarest.client

import com.example.accessingmongodbdatarest.cliente.Client
import com.example.accessingmongodbdatarest.cliente.ClientController
import com.example.accessingmongodbdatarest.cliente.ClientRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification

class SpecCliente extends Specification {
    ClientController controller
    MockMvc mockMvc
    ClientRepository repository
    ObjectMapper mapper = new ObjectMapper()


    Client jon
    String jonJsonString



    def 'create a client with target number and benefict'(){
        given: 'Creamos un cliente con target number'
        repository = Mock(ClientRepository)
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .alwaysDo(MockMvcResultHandlers.print())
                .build()
        jon = new Client([id: 1, firstName: 'Jon', lastName: 'Snow','target_number':01234567,'benefict':true])
        jonJsonString = mapper.writeValueAsString(jon)


        when: 'Lo guardamos'
        repository.save(Client)

        expect: 'Verificamos que tenga todos los datos mandados'
        MockMvcResultMatchers.content().json(jonJsonString)
    }

}
