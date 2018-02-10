/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tjcs.venture;

import com.sun.nio.file.ExtendedCopyOption;
import java.awt.Frame;
import java.awt.Window;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author bbergeson
 */
public class FileUtilities {

    public static String LAST_DIR_LOCATION = System.getProperty("user.dir");

    public static void setLastDirLocation(String lastDirLocation) {
        LAST_DIR_LOCATION = lastDirLocation;
    }

    /**
     *
     * @param title This is the title that will be displayed in the Title Bar of
     * the Save Dialog window.
     * @param startingDir This is the directory that the Save Dialog will be
     * initialized with.
     * @param extDescription This is the description of the extension files, or
     * the type of files being saved.
     * @param extension The extension that the user should use when entering the
     * save filename. If the user doesn't add it then it will be added
     * automatically.
     * @return The full path and filename, including extension, of the filename
     * to be saved.
     */
    public static String saveFile(String title, String buttonStr, File startingDir, String extDescription, String extension) {
        String filename = "";
        JFileChooser fc = new JFileChooser();
        if (startingDir != null) {
            fc.setCurrentDirectory(startingDir);
        }
        if ((extension != null) && !extension.isEmpty()) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter(extDescription, extension);
            fc.setFileFilter(filter);
            fc.setAcceptAllFileFilterUsed(false);
        } else {
            fc.setAcceptAllFileFilterUsed(true);
        }
        fc.setDialogTitle(title);
        fc.setDialogType(JFileChooser.SAVE_DIALOG);
        if ((buttonStr != null) && !buttonStr.isEmpty()) {
            fc.setApproveButtonText(buttonStr);
            fc.setApproveButtonToolTipText(buttonStr);
        }
        int returnVal = fc.showSaveDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File tmpFile = fc.getSelectedFile();
            if (tmpFile != null && tmpFile.getParentFile() != null) {
                LAST_DIR_LOCATION = tmpFile.getParentFile().getAbsolutePath();
            }
            // if the extension was not typed in by the user then append it.
            if ((extension != null) && !extension.isEmpty() && !tmpFile.getAbsolutePath().endsWith(extension)) {
                String tmpStr = tmpFile.getAbsolutePath() + "." + extension;
                tmpFile = new File(tmpStr);
            }
            return tmpFile.getAbsolutePath();
        }
        return filename;
    }

    /**
     *
     * @param title This is the title that will be displayed in the Title Bar of
     * the Dialog window.
     * @param startingDir This is the directory that the Dialog will be
     * initialized with.
     * @param extDescription This is the description of the extension files, or
     * the type of files to Find.
     * @param extDescription The array of extensions to be located.
     * @param buttonStr the text displayed on the button.
     * @return The full path and filename, including extension, of the located
     * file.
     */
    public static File getFile(String title, File startingDir, String extDescription, String[] extensions, String buttonStr) {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle(title);
        if (startingDir != null) {
            fc.setCurrentDirectory(startingDir);
        }
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(extDescription, extensions);
        fc.setFileFilter(filter);
        int returnVal = fc.showDialog(null, buttonStr);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File tmpFile = fc.getSelectedFile();
            if (tmpFile != null && tmpFile.getParentFile() != null) {
                LAST_DIR_LOCATION = tmpFile.getParentFile().getAbsolutePath();
            }
            return tmpFile;
        }
        return null;
    }

    /**
     * Will pop up a dialog to facilitate the choosing of a directory by the
     * user.
     *
     * @param title This is the title that will be displayed in the Title Bar of
     * the Dialog window.
     * @param startingDir This is the directory that the Dialog will be
     * initialized with.
     * @return The full path chosen by the user.
     */
    public static String getDir(String title, File startingDir) {
        String filename = "";
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle(title);
        if (startingDir != null) {
            fc.setCurrentDirectory(startingDir);
        }
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);
        int returnVal = fc.showDialog(null, "OK");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File tmpFile = fc.getSelectedFile();
            if (!createDir(tmpFile, false)) {
                tmpFile = null;
            }
            if (tmpFile != null && tmpFile.getParentFile() != null) {
                LAST_DIR_LOCATION = tmpFile.getParentFile().getAbsolutePath();
                return tmpFile.getAbsolutePath();
            }
        }
        return filename;
    }

    /**
     * Will pop up a dialog to facilitate the choosing of a file by the user.
     *
     * @param title This is the title that will be displayed in the Title Bar of
     * the Dialog window.
     * @param startingDir This is the directory that the Dialog will be
     * initialized with.
     * @param fileFilter String array, where the 1st element is the description
     * shown in the drop-down. All other elements are valid file extensions.
     * i.e. new String[] {"ASCII Files (.txt, .xml.)", ".txt", ".xml"}
     * @return The file chosen by the user, or the path (with filename) of what
     * was passed in if canceled.
     */
    public static File selectFile(String title, File startingDir, String[] fileFilter) {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle(title);
        if (startingDir != null) {
            fc.setCurrentDirectory(startingDir.getParentFile());
        }
        if (startingDir.isFile() && startingDir.exists()) {
            fc.setSelectedFile(startingDir);
        }
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(false);
        fc.setAcceptAllFileFilterUsed(false);
        if (fileFilter != null
                && fileFilter.length >= 1) {
            final String[] fileFilters = fileFilter;
            fc.setFileFilter(new javax.swing.filechooser.FileFilter() {
                @Override
                public String getDescription() {
                    return fileFilters[0];
                }

                @Override
                public boolean accept(File file) {
                    String fileName = file.getName();
                    if (file.isDirectory()) {
                        return true;
                    } else {
                        //check to see if any are in the iic
                        for (int i = 1; i < fileFilters.length; i++) {
                            if (fileName.endsWith(fileFilters[i])) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            });
        }
        int returnVal = fc.showDialog(null, "Select File");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File tmpFile = fc.getSelectedFile();
            if (tmpFile != null && tmpFile.getParentFile() != null) {
                LAST_DIR_LOCATION = tmpFile.getParentFile().getAbsolutePath();
                if (tmpFile.isFile()) {
                    return tmpFile;
                }
            }
        }
        return null;
    }

    /**
     * Will attempt to create the entire directory structure passed in. If the
     * directory already exists (i.e. is a directory), will return true without
     * taking any action.
     *
     * @param dir The directory to check/create
     * @param silentMode If true, will ask if the directory s/b created (if it
     * does not exist), then show a 'done' dialog. If false, the structure will
     * be created.
     * @return True if the directory already exists or if the directory was
     * successfully created. False if the action to create the directory was
     * cancelled, or if the directory could not be created.
     */
    public static boolean createDir(File dir, boolean silentMode) {
        boolean madeDir;
        Window window = null;
        int createDirectory;
        if (dir.isDirectory()) {
            madeDir = true;
        } else {
            if (!silentMode) {
                window = JOptionPane.getRootFrame();
                createDirectory = JOptionPane.showConfirmDialog((Frame) window, "The selected directory does not exist.  Create the directory?",
                        "Directory Not Found", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            } else {
                createDirectory = JOptionPane.YES_OPTION;
            }
            if (createDirectory == JOptionPane.YES_OPTION) {
                madeDir = dir.mkdirs();
                if (!silentMode) {
                    if (madeDir) {
                        JOptionPane.showMessageDialog((Frame) window, "Directory Created", "Directory Created",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog((Frame) window, "Directory NOT Created", "Directory Creation Error",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            } else {
                madeDir = false;
            }
        }
        return madeDir;
    }

    /**
     * Deletes all files and subdirectories including the root dir. Returns true
     * if all deletions were successful. If a deletion fails, the method stops
     * attempting to delete and returns false.
     */
    public static boolean deleteDirectory(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return (path.delete());
    }

    /**
     * Deletes all files and subdirectories excluding the root dir. Returns true
     * if all deletions were successful. If a deletion fails, the method stops
     * attempting to delete and returns false.
     */
    public static boolean emptyDirectory(File path) {
        boolean deleteOK;
        deleteOK = path.exists();
        if (deleteOK) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteOK = deleteDirectory(files[i]);
                } else {
                    deleteOK = files[i].delete();
                }
                if (!deleteOK) {
                    break;
                }
            }
        }
        return deleteOK;
    }

    /**
     *
     * @param sourceLocation - The source path
     * @param targetLocation - The target path
     * @param filter - If not null then only files matching the filter will be
     * copied. If null, then the filter is ignored and all files will be copied.
     * This method will recursively copy
     * @return true if copy was successful
     * @throws IOException
     */
    public static ArrayList<Path> copyDirectory(File sourceLocation, File targetLocation, FileFilter filter) throws IOException {
        ArrayList<Path> filesCopied = new ArrayList<>();
        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdirs();
            }

            String[] children;
            //if (filter != null) {
            //    children = sourceLocation.list(filter);
            //} else {
                children = sourceLocation.list();
            //}
            for (int i = 0; i < children.length; i++) {
                //System.out.println("copying " + sourceLocation + File.separator + children[i] + " to " + targetLocation);
                filesCopied.addAll(copyDirectory(new File(sourceLocation, children[i]),
                        new File(targetLocation, children[i]), filter));
            }
        } else {
            if (copyFile(sourceLocation.toPath(), targetLocation.toPath())) {
                filesCopied.add(sourceLocation.toPath());
            }
        }
        return filesCopied;
    }

    /**
     * Copies only the directory structure
     *
     * @param sourceLocation - The source path
     * @param targetLocation - The target path
     * @return true if copy was successful
     * @throws IOException
     */
    public static boolean copyDirectoryStructure(File sourceLocation, File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children;
            children = sourceLocation.list();
            File nextDir;
            for (int i = 0; i < children.length; i++) {
                nextDir = new File(sourceLocation, children[i]);
                if (nextDir.isDirectory()) {
                    copyDirectoryStructure(nextDir, new File(targetLocation, children[i]));
                }
            }
        }
        return true;
    }

    /**
     * Copies only the files of the given directory
     *
     * @param sourceLocation Directory to copy the files from
     * @param targetLocation Directory to copy the files to
     * @param filter Specific files to copy
     * @return Returns false if the source location is not a direcotyr, or if a
     * problem occurs when copying over any of the files. Otherwise returns
     * true.
     * @throws IOException
     */
    public static boolean copyRootFiles(File sourceLocation, File targetLocation, FileFilter filter) throws IOException {
        boolean success = true;
        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children;
            //if (filter != null) {
            //    children = sourceLocation.list(filter);
            //} else {
                children = sourceLocation.list();
            //}
            File nextFile;
            for (int i = 0; i < children.length; i++) {
                nextFile = new File(sourceLocation, children[i]);
                if (nextFile.isFile()) {
                    copyFile(nextFile.toPath(), targetLocation.toPath().resolve(children[i]));
                }
            }
        } else {
            success = false;
        }
        return success;
    }

    /**
     * @deprecated This should be replaced with the new nio class
     * Files.copyFile() or our new copyFile method in this same file.
     * @param sourceFile
     * @param targetFile
     * @return
     * @throws IOException
     */
    public static boolean copyFile(File sourceFile, File targetFile) throws IOException {
        if (sourceFile.isDirectory()) {
            return false;
        }
        long lastModified = sourceFile.lastModified();
        OutputStream out;
        try (InputStream in = new FileInputStream(sourceFile)) {
            out = new FileOutputStream(targetFile);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        }
        out.close();
        targetFile.setLastModified(lastModified);
        return true;
    }

    /**
     * Copies the source file to the destination file, preserving the file
     * attributes.  If the destination file exists and is the same, the copy does not
     * occur.
     *
     * @param srcPath the source file to be copied
     * @param destPath the destination path and filename that will exist after
     * the copy
     * @throws IOException if the file cannot be copied or if the OS is Linux
     * and the group is invalid
     */
    public static boolean copyFile(Path srcPath, Path destPath) throws IOException {

        if (Files.isDirectory(srcPath)) {
            throw new IOException("The source path " + srcPath.toString() + " is a directory and should be a file.");
        }

        if (!isDestFileSame(srcPath.toFile(), destPath.toFile())) {
            //Make sure the destination path exists
            if (!destPath.toFile().exists()) {
                destPath.toFile().mkdirs();
            }
            // copy the file
            Path targetPath = Files.copy(srcPath, destPath,
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES,
                    ExtendedCopyOption.INTERRUPTIBLE);
            
            if (targetPath == destPath) {
                return true;
            }
        } else {
            return true;
        }
        return false;
    }

    /**
     * Returns an array of file objects within a directory. If recursive is
     * true, then will go through all subdirectories as well.
     *
     * @param sourceDir Root directory to find the files
     * @param recursive If false, will only return files in the root directory.
     * If true, will include files in any subdirectories
     * @param filter File filter to evaluate only certain files matching the
     * filter's expression
     * @return Array of Files matching the criteria. If sourceDir is a file,
     * then an empty list is returned.
     */
    private static ArrayList<File> getDirFiles(File sourceDir, boolean recursive, FilenameFilter filter) {
        ArrayList<File> fileList = new ArrayList<>();
        if (sourceDir.isDirectory()) {
            String[] children;
            if (filter != null) {
                children = sourceDir.list(filter);
            } else {
                children = sourceDir.list();
            }
            File tempFile;
            for (int i = 0; i < children.length; i++) {
                tempFile = new File(sourceDir, children[i]);
                if (tempFile.isFile()) {
                    fileList.add(tempFile);
                } else if (tempFile.isDirectory()
                        && recursive) {
                    fileList.addAll(getDirFiles(tempFile, recursive, filter));
                }
            }
        }
        return fileList;
    }

    public static ArrayList<Path> getDirFiles(Path sourceDir, boolean recursive, FilenameFilter filter) {
        ArrayList<File> fileList = getDirFiles(sourceDir.toFile(), recursive, filter);
        ArrayList<Path> pathList = new ArrayList<>();
        for (File files : fileList) {
            pathList.add(Paths.get(files.getAbsolutePath()));
        }
        return pathList;
    }

    /**
     * Returns a list of all files that do not exist at the target location or
     * have a different date modified than the source.
     *
     * @param sourceLocation Where the files will be copied from
     * @param targetLocation Where the files will be copied to
     * @param filter File filter to evaluate only certain files matching the
     * filter's expression
     * @return Array of strings representing the filenames to be copied
     */
    public static ArrayList<Path> getFilesToBeUpdated(File sourceLocation, File targetLocation, FileFilter filter) {
        ArrayList<Path> fileList = new ArrayList<>();
        if (sourceLocation.isDirectory()) {
            String[] children;
            //if (filter != null) {
            //    children = sourceLocation.list(filter);
            //} else {
                children = sourceLocation.list();
            //}
            for (int i = 0; i < children.length; i++) {
                //System.out.println("copying " + sourceLocation + File.separator + children[i] + " to " + targetLocation);
                fileList.addAll(getFilesToBeUpdated(new File(sourceLocation, children[i]),
                        new File(targetLocation, children[i]), filter));
            }
        } else {
            if (!isDestFileSame(sourceLocation, targetLocation)) {
                fileList.add(sourceLocation.toPath());
            }
        }
        return fileList;
    }

    /**
     * Checks to see if the target file has the same modified date as the source
     * file. If it is different, the name of the source file is returned.
     *
     * @param sourceFile
     * @param targetFile
     * @return sourceFile name if the last modified dates are different.
     * Otherwise returns null.
     */
    public static boolean isDestFileSame(File sourceFile, File targetFile) {
        if (sourceFile.isDirectory()) {
            return true;
        }
        if (!targetFile.exists()) {
            return false;
        }
        long sourceLastModified = sourceFile.lastModified();
        long targetLastModified = targetFile.lastModified();
        //Turns out the packaging of the file into an exe causes the modified time
        //to possibly be off by up to 2 seconds.  Therefore, check for a
        //difference in the time to see if it's outside of 2 seconds of difference.
        //Could play it same and bump this up to a minute...
        if (Math.abs(sourceLastModified - targetLastModified) > 2000) {
            return false;
        }
        return true;
    }

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if ((i > 0) && (i < (s.length() - 1))) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    /**
     * Returns the prefix of a file, essentially removing the extension. The
     * extension is considered to be anything after the last '.' If a '.' is not
     * found, the name of the file is returned.
     *
     * @param f
     * @return The name of a file without the extension, or the name of the file
     * if no extension is found
     */
    public static String getPrefix(File f) {
        String prefix = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if ((i > 0) && (i < (s.length() - 1))) {
            prefix = s.substring(0, i).toLowerCase();
        } else {
            prefix = s;
        }
        return prefix;
    }

    /**
     * Goes through all files in the directory based on the file filter, and
     * finds the newest file looking at the last modified date.
     *
     * @param filesDirectory Location of the files to search
     * @param filter Filter to apply to the files within the directory
     * @return The newest file in the directory, or null if the filesDirectory
     * is null or not a directory, or if no files are in the directory.
     */
    public static Path getNewestFile(File filesDirectory, FileFilter filter) {
        File tempFile;
        File newestFile = null;
        if (filesDirectory == null) {
            return null;
        }
        if (filesDirectory.isDirectory()) {
            File[] children;
            if (filter != null) {
                children = filesDirectory.listFiles(filter);
            } else {
                children = filesDirectory.listFiles();
            }
            for (int i = 0; i < children.length; i++) {
                tempFile = children[i];
                if (newestFile == null) {
                    newestFile = tempFile;
                    continue;
                }
                if (tempFile.lastModified() > newestFile.lastModified()) {
                    newestFile = tempFile;
                }
            }
        }
        if (newestFile == null) {
            return null;
        }
        return Paths.get(newestFile.toURI());
    }

    public static String getPathOnly(File file) {
        String filePath = file.getAbsolutePath();
        filePath = filePath.substring(0, filePath.lastIndexOf(File.separator));
        return filePath;
    }

    public static void writeStringToFile(Path fileDestination, StringBuffer stringToWrite, boolean append) throws IOException {
        if (fileDestination == null) {
            throw new IOException("File Destination is NULL");
        }
        if (!fileDestination.toFile().exists()) {
            //Get the root directory
            File fileDestinationPath = fileDestination.getParent().toFile();
            if (!fileDestinationPath.exists()
                    && !fileDestinationPath.mkdirs()) {
                throw new IOException("Couldn't make the path");
            }
        }
        File targetFile = fileDestination.toFile();
        if (targetFile.isDirectory()) {
            throw new IOException("The target file is a directory.");
        }
        FileWriter targetWriter = null;
        try {
            targetWriter = new FileWriter(targetFile, append);
            targetWriter.write(stringToWrite.toString());
        } catch (IOException ex) {
            throw ex;
        } finally {
            try {
                if (targetWriter != null) {
                    targetWriter.close();
                }
            } catch (IOException ex) {
                throw ex;
            }
        }
    }

    public static StringBuffer readStringFromFile(String fileName) throws IOException {
        File sourceFile = new File(fileName);
        StringBuffer fileString = new StringBuffer("");
        if (sourceFile.isDirectory()) {
            throw new IOException("The target file is a directory.");
        }
        BufferedReader sourceDataReader = new BufferedReader(new FileReader(sourceFile));
        String dataLine;
        while ((dataLine = sourceDataReader.readLine()) != null) {
            fileString.append(dataLine);
        }
        return fileString;
    }

    public static ArrayList<String> readLinesFromFile(Path path) throws IOException {
        File sourceFile = path.toFile();// new File(path);
        ArrayList<String> lineStrings = new ArrayList<>();
        if (!sourceFile.exists()) {
            return lineStrings;
        }
        if (sourceFile.isDirectory()) {
            throw new IOException("The target file is a directory.");
        }
        try (BufferedReader sourceDataReader = new BufferedReader(new FileReader(sourceFile))) {
            String dataLine;
            while ((dataLine = sourceDataReader.readLine()) != null) {
                lineStrings.add(dataLine);
            }
        }
        return lineStrings;
    }

    /**
     * Unzips files and directories from a zipped file. If any destination files
     * exist, they are deleted then recreated. An existing destination directory
     * structure remains intact.
     *
     * @param zippedFile Name of the zipped file to extract
     * @param filesDestination Root destination for all files and directories to
     * go
     * @param filter Filter to apply to files with the archive
     * @return A list of the files successfully extracted.
     */
    public static ArrayList<Path> unZipFiles(Path zippedFile, Path filesDestination, FileFilter filter) {
        ArrayList<Path> extractedFiles = new ArrayList<>();
        if (!zippedFile.toFile().exists() || filesDestination == null) {
            return null;
        }
        if (!filesDestination.toFile().exists()) {
            if (!filesDestination.toFile().mkdirs()) {
                return null;
            }
        }
        try {
            return unZipFiles(new FileInputStream(zippedFile.toFile()), filesDestination, filter);
        } catch (FileNotFoundException ex) {
            return extractedFiles;
        }
    }

    /**
     * Unzips files and directories from a zipped file. If any destination files
     * exist, they are deleted then recreated. An existing destination directory
     * structure remains intact.
     *
     * @param zippedFile Name of the zipped file to extract
     * @param filesDestination Root destination for all files and directories to
     * go
     * @param filter Filter to apply to files with the archive
     * @return A list of the files successfully extracted.
     */
    public static ArrayList<Path> unZipFiles(InputStream zipStream, Path filesDestination, FileFilter filter) {
        ArrayList<Path> extractedFiles = new ArrayList<>();
        if (filesDestination == null) {
            return null;
        }
        if (!filesDestination.toFile().exists()) {
            if (!filesDestination.toFile().mkdirs()) {
                return null;
            }
        }
        ZipInputStream inZip = null;
        ZipEntry inZipEntry;
        try {
            inZip = new ZipInputStream(zipStream);
        } catch (Exception ex) {
            return extractedFiles;
        }
        byte[] byteBuffer = new byte[2048]; //Size based on an example I saw...
        boolean filesLeft = true;
        //The try-catch is inside the while loop so attempts to extract files will continue even
        //if an exception is caught.
        while (filesLeft) {
            try {
                inZipEntry = inZip.getNextEntry();
                if (inZipEntry == null) {
                    filesLeft = false;
                    continue;
                }
                //Use the same name as the entry for the file destination
                File unZippedFile = filesDestination.resolve(inZipEntry.getName()).toFile();
                //if (filter != null
                //        && !filter.accept(null, inZipEntry.getName())) {
                //    continue;
                //}
                if (inZipEntry.isDirectory()) {
                    unZippedFile.mkdirs();
                    continue;
                }
                //Check to see if the entry includes a directory not yet created
                Path filePath = Paths.get(unZippedFile.getParent());
                if (filePath != null
                        && !filePath.toFile().exists()
                        && !filePath.toFile().mkdirs()) {
                    throw new Exception("Unable to create " + filePath.toString());
                }
                if (unZippedFile.exists()) {
                    unZippedFile.delete();
                }
                unZippedFile.createNewFile();
                FileOutputStream unZippedFileOutputStream = new FileOutputStream(unZippedFile);
                int length;
                //inZip.read reads only from the currently selected entry as previously identified
                //by getNextEntry()
                while ((length = inZip.read(byteBuffer)) > 0) {
                    unZippedFileOutputStream.write(byteBuffer, 0, length);
                }
                unZippedFileOutputStream.close();
                unZippedFile.setLastModified(inZipEntry.getTime());
                extractedFiles.add(Paths.get(unZippedFile.toURI()));
            } catch (Exception ex) {
                Logger.getLogger(FileUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            inZip.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }

        return extractedFiles;
    }

}
