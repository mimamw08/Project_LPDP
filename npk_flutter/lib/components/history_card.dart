import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class HistoryCard extends StatelessWidget {
  const HistoryCard({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Container(
        child: Container(
            height: 115,
            decoration: BoxDecoration(
              borderRadius: BorderRadius.all(Radius.circular(24)),
              image: DecorationImage(
                image: AssetImage("assets/images/tanaman2.png"),
                fit: BoxFit.cover,
                colorFilter: ColorFilter.mode(
                    Colors.black.withOpacity(0.1), BlendMode.darken),
                alignment: Alignment.center,
              ),
            ),
            alignment: Alignment.center,
            child: Column(
              children: <Widget>[
                SizedBox(
                  height: 20,
                ),
                Align(
                  alignment: Alignment.center,
                  child: Column(
                    children: [
                      Image(
                        image: AssetImage('assets/icon/history_white.png'),
                      ),
                    ],
                  ),
                ),
                Text(
                  "History",
                  style: GoogleFonts.roboto(
                      fontSize: 25,
                      fontWeight: FontWeight.w700,
                      color: Colors.white),
                ),
              ],
            )),
      ),
    );
  }
}
