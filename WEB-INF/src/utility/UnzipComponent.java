package utility;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;



public class UnzipComponent {

	   public static void unzip(String userId,String inputZipFile, String outputFile) {
	      try {
	         File zipFile = new File(inputZipFile);
	         // 出力先ディレクトリを作成
	         File outputDirectry = createOutputDirectry(zipFile,
	               outputFile);
	         unzip(zipFile, outputDirectry);
	         zipFile.delete();
	         deleteDir(outputFile);
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	   }

	   

	private static void deleteDir(String outputFile) {
		// TODO Auto-generated method stub
		File file = new File(outputFile);
		File[] files = file.listFiles();
		for(int i=0 ; i<files.length; i++){
			if(files[i].getName().startsWith("_")){
				recursiveDelete(files[i]);
			}
		}
	}



	private static void recursiveDelete(File file) {
		// TODO Auto-generated method stub
		for (File f : file.listFiles()) {
			  if (f.isDirectory()) {
				  recursiveDelete(f);
			  } 
			  else{
				  f.delete();
			  }
		}
		file.delete();
	}



	/**
	    * 出力先ディレクトリを作成
	    * @param zipFile 解凍対象のZip　File
	    * @param outputFile 出力先ディレクトリ
	    * @return　出力先ディレクトリ
	    * @throws FileNotFoundException 
	    */
	   private static File createOutputDirectry(final File zipFile,
	         final String outputFile) throws FileNotFoundException {
	      File outputDirectry;
	      if (outputFile != null) {
	         outputDirectry = new File(outputFile);
	      } else {
	         // 出力先ディレクトリが指定されない場合、 対象のZipファイルと同名のディレクトリを作成
	         String fileName = zipFile.getName();
	         int indexOfExtention = fileName.lastIndexOf(".");
	         String baseDirectryName = fileName.substring(0, indexOfExtention);
	         outputDirectry = new File(zipFile.getParent(), baseDirectryName);
	      }
	      if (!outputDirectry.exists()) {
	         // 出力先ディレクトリが存在しない場合、作成
	         if (!outputDirectry.mkdir()) {
	            throw new FileNotFoundException(outputDirectry + "の生成に失敗しました。");
	         }
	      }
	      return outputDirectry;
	   }

	   private static void unzip(File zipFile, File baseDirectry) {
	      try (ZipFile zip = new ZipFile(zipFile, "Windows-31J")) {
	         Enumeration<? extends ZipArchiveEntry> entries = zip.getEntries();
	         while (entries.hasMoreElements()) {
	            ZipArchiveEntry zipEntry = entries.nextElement();

	            File outFile = new File(baseDirectry, zipEntry.getName());
	            if (zipEntry.isDirectory()) {
	               // ZipEntry がディレクトリの場合はディレクトリを作成。
	               outFile.mkdirs();
	            } else {
	        
	               try (InputStream inputStream = zip.getInputStream(zipEntry);
	                     BufferedInputStream bufferedInputStream = new BufferedInputStream(
	                           inputStream);) {
	                  if (!outFile.getParentFile().exists()) {
	                     // 出力先ファイルの保存先ディレクトリが存在しない場合は、
	                     // ディレクトリを作成しておく。
	                     outFile.getParentFile().mkdirs();
	                  }
	                  try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
	                        new FileOutputStream(outFile));) {
	                     // 入力ストリームから読み込み、出力ストリームへ書き込む。
	                     writeStream(bufferedInputStream,
	                           bufferedOutputStream);
	                  }
	               }
	            }
	         }
	      } catch (ZipException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }

	   private static void writeStream(InputStream inputStream,
	         OutputStream outputStream) throws IOException {
	      int availableByteNumber;
	      while ((availableByteNumber = inputStream.available()) > 0) {
	         byte[] buffers = new byte[availableByteNumber];
	         int readByteNumber = inputStream.read(buffers);
	         if (readByteNumber < 0) {
	            break;
	         }
	         outputStream.write(buffers, 0, readByteNumber);
	      }
	   }
	}
