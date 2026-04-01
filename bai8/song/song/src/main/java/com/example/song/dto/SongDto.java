package com.example.song.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {

    private int id;
    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không vượt quá 800 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-]*$", message = "Tên bài hát không chứa các kí tự đặc biệt như @ ; , . = - +")
    private String name;

    @NotBlank(message = "Nghệ sĩ không được để trống")
    @Size(max = 300, message = "Tên nghệ sĩ không vượt quá 300 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-]*$", message = "Tên nghệ sĩ không được chứa các kí tự đặc biệt như @ ; , . = - +")
    private String artist;

    @NotBlank(message = "Thể loại không được để trống")
    @Size(max = 1000, message = "Thể loại không vượt quá 1000 ký tự")
    @Pattern(regexp = "^[^@;.=+\\-]*$", message = "Thể loại không chứa ký tự đặc biệt (ngoại trừ dấu phẩy)")
    private String genre;
}