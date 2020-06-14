package com.jflopezfernandez.validator;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

/**
 * This class contains the entry point to the XML Schema validation utility.
 *
 * @author Jose Fernando Lopez Fernandez <jflopezfernandez@gmail.com>
 */
public class Main {

    /**
     * This is the entry point of the validation utility.
     *
     * @author Jose Fernando Lopez Fernandez <jflopezfernandez@gmail.com>
     *
     * @param args The filename of the schema, followed by all of the files to validate against it.
     */
    public static void main(String[] args) {
        /**
         * Verify the user supplied at least one argument when calling the program.
         */
        if (args.length == 0) {
            /**
             * Simply display the help menu and exit with an error status code.
             */
            /** @todo Create help menu display function */
            System.err.println("Usage: validate <SchemaFile> <XmlFile> [<XmlFiles>...]");
            System.exit(1);
        }

        /** @todo Load the schema */
        /** @todo Validate files against the schema */
        System.out.println("Simulating program execution...");
    }
}
