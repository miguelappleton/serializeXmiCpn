package com.springboot.simul;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import io.github.abelgomez.cpntools.Cpnet;
import io.github.abelgomez.cpntools.io.serializer.CpnToolsBuilder;

@Service
@Validated
public class SimulationServiceService {

	public String simulateSequence() {

		try {
			
			/*
			 * To run the project, just use "spring-boot:run" as the Run Configurations'
			 * Goal
			 * 
			 * To test the project, you should send an empty request (using Postman, for
			 * example) to "localhost:8080/simulate"
			 * 
			 * I removed the unnecessary code to make it simpler to solve this problem
			 */
			
			
			
			/*
			 * The project finds no errors if I simply import the plug-in projects into this
			 * Maven project's classpath, and because of this I can actually run the Maven project
			 * 
			 * But if I run it, I get ClassNotFound errors, so this is not the right way to
			 * import the plug-ins either
			 */
			
			
			
			
			// So, starting already with a XMI Petri net model,
			// here is where I would obtain the Cpnet element from the that model
						
			ResourceSet resourceSet = new ResourceSetImpl();
			
			URI m = URI.createFileURI("src/main/sequence/cpnmeta.ecore");
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
			
			URI u = URI.createFileURI("src/main/sequence/cpnModel.model");
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("model", new XMIResourceFactoryImpl());
			
			Resource resource = resourceSet.getResource(u, true);
			resource.load(Collections.emptyMap());
			Cpnet net = (Cpnet) resource.getContents().get(0);
			
			// (If the plugin is installed correctly, perhaps lines 61 and 62
			// are not necessary, but for now I need to keep them, otherwise I get errors)
			
			
			
			
			// Here I would generate the ".cpn" file
			// but I get a ClassNotFound exception for the CpnToolsBuilder class
			CpnToolsBuilder builder = new CpnToolsBuilder(net);
			builder.serialize(System.out);
			builder.serialize(new FileOutputStream(new File("src/main/sequence/cpnModel.cpn")));


			return "the result of the cpn file simulation (ommited here)";	
		}
		catch (Exception e) {e.printStackTrace(); return e.getMessage();}
	}
}