import 'package:npk_flutter/new_register_screen.dart';
import 'package:npk_flutter/signup_screen.dart';
import 'package:npk_flutter/testpage.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:flutter/material.dart';
import 'package:npk_flutter/widget/customWidget.dart';

class login_screen extends StatelessWidget {
  const login_screen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        decoration: BoxDecoration(
            image: DecorationImage(
          image: AssetImage('assets/images/tanaman.png'),
          fit: BoxFit.cover,
          // colorFilter: ColorFilter.mode(
          //     Colors.black.withOpacity(0.2), BlendMode.dstATop)
        )),
        child: SingleChildScrollView(
          padding: EdgeInsets.symmetric(horizontal: 8),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              SizedBox(
                height: 150,
              ),
              FrontBox(
                child: Container(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: <Widget>[
                      SizedBox(
                        height: 2,
                      ),
                      RichText(
                        textAlign: TextAlign.center,
                        text: TextSpan(
                          text: 'LOGIN',
                          style: GoogleFonts.roboto(
                            fontSize: 28,
                            fontWeight: FontWeight.w400,
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
                            'SIGN IN',
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
                                image:
                                    AssetImage("assets/icon/google_icon.png"),
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
                        child: TextButton(
                            onPressed: () {
                              showDialog(
                                  context: context,
                                  builder: (BuildContext context) =>
                                      AlertDialog(
                                        title: Text("Coming Soon"),
                                      ));
                            },
                            child: Text(
                              "Forgot Password?",
                              style: GoogleFonts.roboto(
                                  fontSize: 14,
                                  fontWeight: FontWeight.w400,
                                  color: Colors.black),
                            )),
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
                                  builder: (context) => register_screen()));
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
              SizedBox(
                height: 50,
              ),
            ],
          ),
        ),
      ),
    );
  }
}
