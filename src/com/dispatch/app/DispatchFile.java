package com.dispatch.app;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
 
public class DispatchFile {
	
	public static String readDispatchreference(String filePath) {
		if(filePath != null) {
    		System.out.println("From func << " + filePath);
    		String data = "";
    		
        	
        	String strFileDirectoryPath = DirectoryPaths.outputDir + filePath;
        	
        	try {
        	FileInputStream fstream = new FileInputStream(strFileDirectoryPath);
        	DataInputStream in = new DataInputStream(fstream);
        	BufferedReader br = new BufferedReader(new InputStreamReader(in));
        	String strLine;
        	// Read File Line By Line
        	while ((strLine = br.readLine()) != null) {
        		System.out.println(strLine);
        	}
        	in.close();
        	} catch (Exception e) {// Catch exception if any
        		System.err.println("Error: " + e.getMessage());
        	}

    	}
		return filePath;
	}

    public static void main (String args[]) {
    	String filePath = null;
    	String extractedDispatchreference = "";
    	WatchFolder watch = new WatchFolder();
    	
    	
    	filePath = watch.watchFolder().toString();
    	System.out.println("From main >> "+filePath);
    	if(filePath != null) {
    		extractedDispatchreference = readDispatchreference(filePath);
    	}
    	
    	
    }
    	
}
 
