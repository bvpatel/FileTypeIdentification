package com.blueoptima.filetypeidentification;

import com.blueoptima.filetypeidentification.domain.FileType;
import com.blueoptima.filetypeidentification.service.FileExtensionService;
import com.blueoptima.filetypeidentification.util.FileUtil;
import org.apache.commons.cli.*;

import java.util.List;

/**
 * The {@link FileTypeIdentificationApplication} represents the application
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public class FileTypeIdentificationApplication {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Options  options = new Options();

        Option input = new Option("i", "inputFile", true, "File that contains file names or file types");
        input.setRequired(true);
        options.addOption(input);

        Option output = new Option("o", "outputFile", true, "File to store result");
        output.setRequired(true);
        options.addOption(output);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
            return;
        }

        String inputFilePath = cmd.getOptionValue("inputFile");
        String outputFilePath = cmd.getOptionValue("outputFile");
        System.out.println("Input path:" + inputFilePath);
        System.out.println("Output path:" + outputFilePath);
        String[] fileNames = FileUtil.readFileByFileName(inputFilePath);
        FileExtensionService fileExtensionService = new FileExtensionService();
        List<FileType> fileTypes = fileExtensionService.findFileTypeInfomations(fileNames);
        FileUtil.writeFile(outputFilePath,fileTypes);
        System.out.println("Time Taken: " + ((System.currentTimeMillis() - time) / 1000) + " sec");
    }

    public void testData() {
        FileExtensionService fileExtensionService = new FileExtensionService();
        String[] fileTypes = {"txt", "java", "csv", "dsd.word", "a.png", "jpg", "exe", "pdf", "a", "asm", "asp", "awk", "bat", "bmp", "btm", "BTM", "c", "class", "cmd", "CPP", "csv", "cur", "cxx", "CXX", "db", "def", "DES", "dlg", "dll", "don", "dpc", "dpj", "dtd", "dump", "dxp", "eng", "exe", "flt", "fmt", "font", "fp", "ft", "gif", "h", "H", "hdb", "hdl", "hid", "hpp", "hrc", "HRC", "html", "hxx", "Hxx", "HXX", "ico", "idl", "IDL", "ih", "ilb", "inc", "inf", "ini", "inl", "ins", "java", "jar", "jnl", "jpg", "js", "jsp", "kdelnk", "l", "lgt", "lib", "lin", "ll", "LN3", "lng", "lnk", "lnx", "LOG", "lst", "lst", "mac", "MacOS", "map", "mk", "MK", "mod", "NT2", "o", "obj", "par", "pfa", "pfb", "pl", "PL", "plc", "pld", "PLD", "plf", "pm", "pmk", "pre", "PRJ", "prt", "PS", "ptr", "r", "rc", "rdb", "res", "s", "sbl", "scp", "scr", "sda", "sdb", "sdc", "sdd", "sdg", "sdm", "sds", "sdv", "sdw", "sdi", "seg", "SEG", "Set", "sgl", "sh", "sid", "smf", "sms", "so", "sob", "soh", "sob", "soc", "sod", "soe", "sog", "soh", "src", "srs", "SSLeay", "Static", "tab", "TFM", "thm", "tpt", "tsc", "ttf", "TTF", "txt", "TXT", "unx", "UNX", "urd", "url", "VMS", "vor", "W32", "wav", "wmf", "xml", "xpm", "xrb", "y", "yxx", "zip"};
        long time = System.currentTimeMillis();
        fileExtensionService.findFileTypeInfomations(fileTypes).forEach(System.out::println);
        System.out.println("Time Taken: " + ((System.currentTimeMillis() - time) / 1000) + " sec");
    }
}
