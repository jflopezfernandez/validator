package com.jflopezfernandez.validator;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

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
     * The schema object constructor helper.
     */
    private static SchemaFactory factory = null;

    /**
     * The schema against which we will be validating.
     */
    private static Schema schema = null;

    /**
     * The class in charge of carrying out the actual validation.
     */
    private static Validator validator = null;

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

        /**
         * @todo Load the schema
         */
        try {
            factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schema = factory.newSchema(new File(args[0]));
        } catch (IOException ioException) {
            /**
             * @todo Actually handle the potential IOException
             */
            System.err.println("[Error]: " + ioException.getMessage());
            System.exit(1);
        } catch (SAXException saxException) {
            /**
             * @todo Actually handle the potential SAXException
             */
            System.err.println("[SAX Exception]: " + saxException.getMessage());
            System.exit(1);
        }

        for (String arg : args) {
            /**
             * Skip the first argument, as it was the schema itself.
             */
            if (arg.equals(args[0])) {
                continue;
            }

            /**
             * Check whether the file correctly adheres to the specified schema.
             */
            try {
                validator.validate(new StreamSource(new File(arg)));
            } catch (IOException ioException) {
                System.out.println(String.format(Locale.getDefault(), "[IOException] %s", ioException.getLocalizedMessage()));
            } catch (SAXException saxException) {
                System.out.println(String.format(Locale.getDefault(), "[%s] %s", arg, saxException.getLocalizedMessage()));
                continue;
            }

            System.out.println(String.format(Locale.getDefault(), "[%s] File is valid", arg));
        }

        /** @todo Validate files against the schema */
        System.out.println("Simulating program execution...");
    }
}
