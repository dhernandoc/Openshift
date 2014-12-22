/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.prueba.damecita.service.impl;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.prueba.damecita.model.Cita;
import es.prueba.damecita.model.Paciente;
import es.prueba.damecita.model.Profesional;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class ProfesionalServiceImpl {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;


    public void create(Profesional profesional) throws Exception {
        log.info("Creando Profesional " + profesional.getNombre());
        em.persist(profesional);
    }

    public void delete(Long idProfesional) throws Exception {
        log.info("Borrando Profesional " + idProfesional);
        Profesional profesional = em.find(Profesional.class, idProfesional);
        em.remove(profesional);
    }

    
}
