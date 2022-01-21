import 'dart:math';

import 'package:google_fonts/google_fonts.dart';
import 'package:npk_flutter/Widget/costumClipper.dart';
import 'package:npk_flutter/home_screen.dart';
import 'package:npk_flutter/signup_screen.dart';
import 'package:flutter/material.dart';
import 'package:npk_flutter/testpage.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  _LoginScreenState createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  @override
  Widget build(BuildContext context) {
    final height = MediaQuery.of(context).size.height;
    return Scaffold(
      body: Container(
        height: height,
        child: Stack(
          children: <Widget>[
            Positioned(
              top: -MediaQuery.of(context).size.height * .15,
              right: -MediaQuery.of(context).size.width * .4,
              child: Container(
                child: Transform.rotate(
                  angle: -pi / 3.5,
                  child: ClipPath(
                    clipper: ClipPainter(),
                    child: Container(
                      height: MediaQuery.of(context).size.height * .5,
                      width: MediaQuery.of(context).size.width,
                      decoration: BoxDecoration(
                        gradient: LinearGradient(
                          begin: Alignment.topCenter,
                          end: Alignment.bottomCenter,
                          colors: [
                            Color(0xffE6E6E6),
                            Color(0xff3D9339),
                          ],
                        ),
                      ),
                    ),
                  ),
                ),
              ),
            ),
            Container(
              padding: EdgeInsets.symmetric(horizontal: 40),
              child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    SizedBox(
                      height: height * .2,
                    ),
                    RichText(
                      textAlign: TextAlign.center,
                      text: TextSpan(
                        text: 'SIGN IN',
                        style: GoogleFonts.roboto(
                          fontSize: 30,
                          fontWeight: FontWeight.w700,
                          color: Color(0xff000000),
                        ),
                        /*children: [
                          TextSpan(
                            text: 'pna',
                            style: TextStyle(color: Colors.black, fontSize: 30),
                          ),
                        ],*/
                      ),
                    ),
                    SizedBox(
                      height: 20,
                    ),
                    Column(
                      children: <Widget>[
                        Container(
                          margin: EdgeInsets.symmetric(vertical: 10),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: <Widget>[
                              SizedBox(
                                height: 5,
                              ),
                              TextField(
                                obscureText: false,
                                decoration: InputDecoration(
                                    border: InputBorder.none,
                                    fillColor: Color(0xfff3f3f4),
                                    filled: true,
                                    hintText: 'Username'),
                              ),
                            ],
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.symmetric(vertical: 10),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: <Widget>[
                              SizedBox(
                                height: 5,
                              ),
                              TextField(
                                obscureText: true,
                                decoration: InputDecoration(
                                    border: InputBorder.none,
                                    fillColor: Color(0xfff3f3f4),
                                    filled: true,
                                    hintText: 'Password'),
                              ),
                            ],
                          ),
                        ),
                      ],
                    ),
                    SizedBox(
                      height: 10,
                    ),
                    GestureDetector(
                      onTap: () => Navigator.pushReplacement(
                        context,
                        MaterialPageRoute(
                          builder: (context) => TestPage(),
                        ),
                      ),
                      child: Container(
                        width: MediaQuery.of(context).size.width,
                        padding: EdgeInsets.symmetric(vertical: 10),
                        alignment: Alignment.center,
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.all(Radius.circular(11)),
                          boxShadow: <BoxShadow>[
                            BoxShadow(
                              color: Colors.grey.shade200,
                              offset: Offset(2, 4),
                              blurRadius: 5,
                              spreadRadius: 2,
                            ),
                          ],
                          gradient: LinearGradient(
                            begin: Alignment.centerLeft,
                            end: Alignment.centerRight,
                            colors: [
                              Color(0xff3D9339),
                              Color(0xff3D9339),
                            ],
                          ),
                        ),
                        child: Text(
                          'Sign In',
                          style: TextStyle(fontSize: 20, color: Colors.white),
                        ),
                      ),
                    ),
                    SizedBox(
                      height: 10,
                    ),
                    GestureDetector(
                      /*onTap: () => Navigator.pushReplacement(
                          context,
                          MaterialPageRoute(
                            builder: (context)=> HomeScreen(),
                            ),
                          ),*/
                      child: Container(
                        width: MediaQuery.of(context).size.width,
                        padding: EdgeInsets.symmetric(vertical: 10),
                        alignment: Alignment.center,
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.all(Radius.circular(11)),
                          image: DecorationImage(
                            image: AssetImage("assets/icon/bi_phone.png"),
                            alignment: Alignment.centerLeft,
                          ),
                          boxShadow: <BoxShadow>[
                            BoxShadow(
                              color: Colors.grey.shade200,
                              offset: Offset(2, 4),
                              blurRadius: 5,
                              spreadRadius: 2,
                            ),
                          ],
                          gradient: LinearGradient(
                            begin: Alignment.centerLeft,
                            end: Alignment.centerRight,
                            colors: [
                              Color(0xfff3f3f4),
                              Color(0xfff3f3f4),
                            ],
                          ),
                        ),
                        child: Text(
                          'Continue with Phone Number',
                          style: TextStyle(fontSize: 14, color: Colors.black),
                        ),
                      ),
                    ),
                    SizedBox(
                      height: 10,
                    ),
                    GestureDetector(
                      /*onTap: () => Navigator.pushReplacement(
                          context,
                          MaterialPageRoute(
                            builder: (context)=> HomeScreen(),
                            ),
                          ),*/
                      child: Container(
                        width: MediaQuery.of(context).size.width,
                        padding: EdgeInsets.symmetric(vertical: 10),
                        alignment: Alignment.center,
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.all(Radius.circular(11)),
                          image: DecorationImage(
                              image: AssetImage("assets/icon/google_icon.png"),
                              alignment: Alignment.centerLeft),
                          boxShadow: <BoxShadow>[
                            BoxShadow(
                              color: Colors.grey.shade200,
                              offset: Offset(2, 4),
                              blurRadius: 5,
                              spreadRadius: 2,
                            ),
                          ],
                          gradient: LinearGradient(
                            begin: Alignment.centerLeft,
                            end: Alignment.centerRight,
                            colors: [
                              Color(0xfff3f3f4),
                              Color(0xfff3f3f4),
                            ],
                          ),
                        ),
                        child: Text(
                          'Continue with Google',
                          style: TextStyle(fontSize: 14, color: Colors.black),
                        ),
                      ),
                    ),
                    SizedBox(
                      height: 10,
                    ),
                    GestureDetector(
                      /*onTap: () => Navigator.pushReplacement(
                          context,
                          MaterialPageRoute(
                            builder: (context)=> HomeScreen(),
                            ),
                          ),*/
                      child: Container(
                        width: MediaQuery.of(context).size.width,
                        padding: EdgeInsets.symmetric(vertical: 10),
                        alignment: Alignment.center,
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.all(Radius.circular(11)),
                          image: DecorationImage(
                              image:
                                  AssetImage("assets/icon/facebook_icon.png"),
                              alignment: Alignment.centerLeft),
                          boxShadow: <BoxShadow>[
                            BoxShadow(
                              color: Colors.grey.shade200,
                              offset: Offset(2, 4),
                              blurRadius: 5,
                              spreadRadius: 2,
                            ),
                          ],
                          gradient: LinearGradient(
                            begin: Alignment.centerLeft,
                            end: Alignment.centerRight,
                            colors: [
                              Color(0xfff3f3f4),
                              Color(0xfff3f3f4),
                            ],
                          ),
                        ),
                        child: Text(
                          'Continue with Facebook',
                          style: TextStyle(fontSize: 14, color: Colors.black),
                        ),
                      ),
                    ),
                    SizedBox(
                      height: 15,
                    ),
                    Container(
                      padding: EdgeInsets.symmetric(vertical: 10),
                      alignment: Alignment.center,
                      child: Text(
                        'Forgot Password ?',
                        style: TextStyle(
                            fontSize: 14, fontWeight: FontWeight.w500),
                      ),
                    ),
                    SizedBox(
                      //height: height * .055,
                      height: 1,
                    ),
                    InkWell(
                      onTap: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => SignUpScreen()));
                      },
                      child: Container(
                        margin: EdgeInsets.symmetric(vertical: 20),
                        padding: EdgeInsets.all(15),
                        alignment: Alignment.bottomCenter,
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: <Widget>[
                            Text(
                              'Don\'t have account?',
                              style: TextStyle(
                                fontSize: 13,
                                fontWeight: FontWeight.w400,
                              ),
                            ),
                            SizedBox(
                              width: 10,
                            ),
                            Text(
                              'Sign Up',
                              style: TextStyle(
                                color: Color(0xff3D9339),
                                fontSize: 13,
                                fontWeight: FontWeight.w600,
                              ),
                            ),
                          ],
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ),
            Positioned(
              top: 40,
              left: 0,
              child: InkWell(
                onTap: () {
                  Navigator.pop(context);
                },
                child: Container(
                  padding: EdgeInsets.symmetric(horizontal: 10),
                  child: Row(
                    children: <Widget>[
                      Container(
                        padding: EdgeInsets.only(left: 0, top: 10, bottom: 10),
                        child: Icon(
                          Icons.keyboard_arrow_left,
                          color: Colors.black,
                        ),
                      ),
                      Text(
                        'Back',
                        style: TextStyle(
                          fontSize: 12,
                          fontWeight: FontWeight.w500,
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
