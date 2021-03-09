package com.springboot.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity.BodyBuilder;

import com.springboot.demo.model.PatientImage;
import com.springboot.demo.repository.PatientImageRepository;

@CrossOrigin(origins="*",allowedHeaders = "*")
@RestController
@RequestMapping("/MediTrackProject1")
public class PatientImageController {
	
	@Autowired 
	private PatientImageRepository patientimagerepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/uploadPIm/{id}")
	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file,@PathVariable Long id) throws IOException {

		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		Long l= new Long(id);
		int i=l.intValue();
		PatientImage img = new PatientImage(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()),i);
		patientimagerepository.save(img);
		return ResponseEntity.status(HttpStatus.OK);
	}

	@GetMapping(path = { "/getPI/{id}" })
	public PatientImage getImage(@PathVariable int id) throws IOException {

		final Optional<PatientImage> retrievedImage = patientimagerepository.findByPid(id);
		PatientImage img = new PatientImage(retrievedImage.get().getName(), retrievedImage.get().getType(),
				decompressBytes(retrievedImage.get().getPicByte()),id);
		return img;
	}

	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}


}
