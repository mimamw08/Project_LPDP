import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:npk_flutter/login_screen.dart';
import 'package:npk_flutter/new_login_screen.dart';
import 'package:npk_flutter/new_register_screen.dart';
import 'package:npk_flutter/signup_screen.dart';
import 'package:npk_flutter/widget/customWidget.dart';

class welcome_screen extends StatelessWidget {
  const welcome_screen({Key? key}) : super(key: key);

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
        child: Container(
          padding: EdgeInsets.symmetric(horizontal: 8),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              SizedBox(
                height: 35,
              ),
              FrontBox(
                  child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  Image(image: AssetImage('assets/icon/daun.png')),
                  SizedBox(
                    height: 30,
                  ),
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
                    height: 60,
                  ),
                  InkWell(
                    onTap: () {
                      Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (context) => login_screen()));
                    },
                    child: Container(
                      width: MediaQuery.of(context).size.width,
                      padding: EdgeInsets.symmetric(vertical: 13),
                      alignment: Alignment.center,
                      decoration: BoxDecoration(
                        borderRadius: BorderRadius.all(Radius.circular(13)),
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
                        style: GoogleFonts.roboto(
                            fontSize: 20, color: Colors.white),
                      ),
                    ),
                  ),
                  SizedBox(
                    height: 5,
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
              )),
            ],
          ),
        ),
      ),
    );
  }
}
