package com.MovieTicketBooking.MovieTicketBooking.Admin;


import com.MovieTicketBooking.MovieTicketBooking.Movie.MovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/api/admindetails")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;

    //admin regtn
    @PostMapping(path = "/addadmin")
    public ResponseEntity<?> addadmin(@RequestBody AdminModel adminModel){
        try{
            return adminService.addadmin(adminModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //admin login
    @PostMapping("/adminlogin")
    public ResponseEntity<?> login(@RequestBody AdminLoginDto adminLoginDto) {
        try {
            boolean isAuthenticated = adminService.adminLogin(adminLoginDto);
            if (isAuthenticated) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong, please try again.");
        }
    }


    //Add movie by admin
    @PostMapping(path = "/addMovie")
    public ResponseEntity<?> addMovie(@RequestPart MovieModel movieModel,
                                      @RequestPart MultipartFile movieposter){
        try{
            return adminService.addmovies(movieModel,movieposter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Delete Movie by admin
    @DeleteMapping(path = "/deletemovie")
    public ResponseEntity<?> deleteMovie(@RequestParam Integer movieId){
        try{
            return adminService.deletemovies(movieId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //update movie name and description
    @PutMapping(path = "/updatemovieNameDes")
    public ResponseEntity<?> updatemovie(@RequestParam Integer movieId,@RequestParam String movieName,@RequestParam String description){
        try{
            return adminService.updateMovieNameAndDes(movieId,movieName,description);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //update movie language and genre
    @PutMapping(path = "/updatemovielangenre")
    public ResponseEntity<?> updatemovie(@RequestParam Integer movieId,@RequestParam Integer language,@RequestParam Integer genre){
        try{
            return adminService.updateMovieLangAndGenre(movieId,language,genre);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong",HttpStatus.OK);
    }

    //Reset password Admin
    @PutMapping(path = "/resetPassword")
    public ResponseEntity<?> updateAdmin(@RequestParam String email,@RequestParam String password){
        try{
            return adminService.updateAdmin(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong",HttpStatus.OK);
    }

}
