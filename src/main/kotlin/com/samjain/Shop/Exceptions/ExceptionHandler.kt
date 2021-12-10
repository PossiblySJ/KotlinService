package com.samjain.Shop.Exceptions

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import java.time.format.DateTimeParseException
import org.springframework.web.bind.annotation.ExceptionHandler




@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoSuchElementException(): ResponseEntity<String> {
        return ResponseEntity("No values present in DB.", HttpStatus.NOT_FOUND)
    }



    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(): ResponseEntity<String> {
        return ResponseEntity("Incorrect input.", HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(DateTimeParseException::class)
    fun handleDateTimeParseException(): ResponseEntity<String> {
        return ResponseEntity("Incorrect input, provide date in in yyyy-mm-dd format.", HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(AlreadyPresentException::class)
    fun handleDataAlreadyPresentException( ex:AlreadyPresentException ): ResponseEntity<String>{
        return ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)

    }
    @ExceptionHandler(NullInputFieldException::class)
    fun handleNullInputException( ex:NullInputFieldException): ResponseEntity<String>{
        return ResponseEntity(ex.message,HttpStatus.BAD_REQUEST)

    }


    @ExceptionHandler(EmptyResultDataAccessException::class)
    fun handleNoMatchingDataException( ): ResponseEntity<String>{
        return ResponseEntity("Store with given id is not present.",HttpStatus.BAD_REQUEST)

    }
}