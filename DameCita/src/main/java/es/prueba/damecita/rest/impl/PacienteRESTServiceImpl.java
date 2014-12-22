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
package es.prueba.damecita.rest.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.prueba.damecita.model.Paciente;
import es.prueba.damecita.rest.PacienteRESTService;
import es.prueba.damecita.service.impl.PacienteServiceImpl;

@Path("/pacientes")
@RequestScoped
public class PacienteRESTServiceImpl extends PacienteServiceImpl implements PacienteRESTService {

    @Inject
    private Logger log;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Paciente> listAllPacientes() {
    	System.out.println("Paso");
    	log.severe("Caca");
    	List<Paciente> resultado = null;
    	try
    	{
    		resultado = super.listAllPacientes();
    	}
		catch (Exception ex)
		{
			log.severe(ex.getMessage());
		}
    	
    	return resultado;
	}


	@Override
	public Response createPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		try
		{
			super.create(paciente);
		}
		catch (Exception ex)
		{
			log.severe(ex.getMessage());
		}
	    return Response.ok(paciente).build();
	}

		@Override
		public Response deleteById(Long id) {
		   try
		   {
			   super.delete(id);
			   return Response.noContent().build();

		   }
		   catch (Exception ex)
		   {
		      return Response.status(Status.NOT_FOUND).build(); 
		   }
		}
	   public Response getPacienteById(@PathParam("id") long id)
	   {
	      Paciente paciente=null;
	      try
	      {
	         paciente = super.findById(id);
	      }
	      catch (Exception nre)
	      {
	    	  log.severe(nre.getMessage());
	      }
	      if (paciente == null)
	      {
	         return Response.status(Status.NOT_FOUND).build();
	      }
	      return Response.ok(paciente).build();
	   }

	   @GET
	   @Produces("application/json")
	   public List<Paciente> listAll(@QueryParam("start") Integer startPosition, @QueryParam("max") Integer maxResult)
	   {
		   List<Paciente> resultado=null;
		   try {
			resultado = super.listAllPacientes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return resultado;
	   }
	   public Response updatePacienteRest(Paciente entity)
	   {
	      try
	      {
	         entity = super.updatePaciente(entity);
	      }
	      catch (Exception e)
	      {
	         return Response.status(Response.Status.CONFLICT).entity(entity).build();
	      }
	      return Response.noContent().build();
	   }



}
