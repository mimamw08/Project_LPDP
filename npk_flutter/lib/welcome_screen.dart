import 'package:npk_flutter/login_screen.dart';
import 'package:npk_flutter/signup_screen.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:flutter/material.dart';

class WelcomeScreen extends StatelessWidget {
  const WelcomeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Container(
          padding: EdgeInsets.symmetric(horizontal: 40),
          height: MediaQuery.of(context).size.height,
          decoration: BoxDecoration(
            borderRadius: BorderRadius.all(Radius.circular(5)),
            boxShadow: <BoxShadow>[
              BoxShadow(
                color: Colors.grey.shade200,
                offset: Offset(2, 4),
                blurRadius: 5,
                spreadRadius: 2,
              )
            ],
            //Image('assets/images/tanaman.png'),
            gradient: LinearGradient(
              begin: Alignment.topCenter,
              end: Alignment.bottomCenter,
              colors: [
                Color(0xffE6E6E6),
                Color(0xffE7EEE6),
              ],
            ),
          ),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              RichText(
                textAlign: TextAlign.center,
                text: TextSpan(
                  text: 'Always Care Your ',
                  style: GoogleFonts.roboto(
                    textStyle: Theme.of(context).textTheme.headline2,
                    fontSize: 19,
                    fontWeight: FontWeight.w500,
                    color: Colors.black,
                    fontStyle: FontStyle.italic,
                  ),
                  children: [
                    TextSpan(
                      text: 'Plants',
                      style: TextStyle(
                        color: Colors.green,
                        fontSize: 19,
                        fontStyle: FontStyle.italic,
                      ),
                    ),
                  ],
                ),
              ),
              SizedBox(
                height: 80,
              ),
              InkWell(
                onTap: () {
                  Navigator.push(context,
                      MaterialPageRoute(builder: (context) => LoginScreen()));
                },
                child: Container(
                  width: MediaQuery.of(context).size.width,
                  padding: EdgeInsets.symmetric(vertical: 13),
                  alignment: Alignment.center,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.all(Radius.circular(5)),
                    boxShadow: <BoxShadow>[
                      BoxShadow(
                        color: Color(0xffE6E6E6).withAlpha(100),
                        offset: Offset(2, 4),
                        blurRadius: 8,
                        spreadRadius: 2,
                      ),
                    ],
                    color: Color(0xff3D9339),
                  ),
                  child: Text(
                    'Sign In',
                    style:
                        GoogleFonts.roboto(fontSize: 20, color: Colors.white),
                  ),
                ),
              ),
              SizedBox(
                height: 5,
              ),
              InkWell(
                onTap: () {
                  Navigator.push(context,
                      MaterialPageRoute(builder: (context) => SignUpScreen()));
                },
                child: Container(
                  margin: EdgeInsets.symmetric(vertical: 20),
                  padding: EdgeInsets.all(15),
                  alignment: Alignment.bottomCenter,
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: <Widget>[
                      Text(
                        'Doesn\'t have an account? ',
                        style: GoogleFonts.roboto(
                          fontSize: 13,
                          fontWeight: FontWeight.w400,
                        ),
                      ),
                      SizedBox(
                        height: 10,
                      ),
                      Text(
                        'Sign Up',
                        style: GoogleFonts.roboto(
                            color: Color(0xff3D9339),
                            fontSize: 13,
                            fontWeight: FontWeight.w600),
                      ),
                    ],
                  ),
                ),
              ),
              SizedBox(
                height: 20,
              ),
            ],
          ),
        ),
      ),
    );
  }
}
