import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:npk_flutter/widget/customWidget.dart';

class Newscard extends StatelessWidget {
  const Newscard({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Container(
        height: 200,
        decoration: BoxDecoration(
          image: DecorationImage(
            image: AssetImage("assets/images/tanaman2.png"),
            fit: BoxFit.cover,
            alignment: Alignment.center,
          ),
        ),
        alignment: Alignment.bottomCenter,
        child: Text(
          "Lorem Ipsum Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
          style: GoogleFonts.roboto(
              fontSize: 14, fontWeight: FontWeight.w400, color: Colors.white),
        ),
      ),
    );
  }
}
