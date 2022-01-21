import 'package:flutter/material.dart';

Widget buildBox({required Widget child}) => Container(
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.all(Radius.circular(27)),
        // border: BoxBorder(
        //   Padding(padding: EdgeInsets.fromLTRB(20.0, 12.0, 12.0, 12.0)),
        // ),
        boxShadow: <BoxShadow>[
          BoxShadow(
            color: Colors.black12,
            blurRadius: 5,
            //offset: Offset(4, 4),
            spreadRadius: 3,
          ),
        ],
      ),
      padding: const EdgeInsets.all(27.0),
      child: child,
    );

Widget CustomBox({required Widget child}) => Container(
      decoration: BoxDecoration(
        color: Colors.green,
        borderRadius: BorderRadius.all(Radius.circular(27)),
        boxShadow: <BoxShadow>[
          BoxShadow(
            color: Colors.black12,
            blurRadius: 5,
            //offset: Offset(4, 4),
            spreadRadius: 3,
          ),
        ],
      ),
      padding: EdgeInsets.all(15),
      child: child,
    );

Widget FrontBox({required Widget child}) => Container(
      decoration: BoxDecoration(
        color: Color(0xffE7EEE6),
        borderRadius: BorderRadius.all(Radius.circular(27)),
        // border: BoxBorder(
        //   Padding(padding: EdgeInsets.fromLTRB(20.0, 12.0, 12.0, 12.0)),
        // ),
        boxShadow: <BoxShadow>[
          BoxShadow(
            color: Colors.black12,
            blurRadius: 5,
            //offset: Offset(4, 4),
            spreadRadius: 3,
          ),
        ],
      ),
      padding: const EdgeInsets.all(27.0),
      child: child,
    );

Widget box1({required Widget child}) => Container(
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.all(Radius.circular(20)),
        // border: BoxBorder(
        //   Padding(padding: EdgeInsets.fromLTRB(20.0, 12.0, 12.0, 12.0)),
        // ),
        boxShadow: <BoxShadow>[
          BoxShadow(
            color: Colors.black12,
            blurRadius: 5,
            //offset: Offset(4, 4),
            spreadRadius: 3,
          ),
        ],
      ),
      padding: EdgeInsets.fromLTRB(20, 19, 20, 18),
      child: child,
    );

Widget box2({required Widget child}) => Container(
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.all(Radius.circular(20)),
        // border: BoxBorder(
        //   Padding(padding: EdgeInsets.fromLTRB(20.0, 12.0, 12.0, 12.0)),
        // ),
        boxShadow: <BoxShadow>[
          BoxShadow(
            color: Colors.black12,
            blurRadius: 5,
            //offset: Offset(4, 4),
            spreadRadius: 3,
          ),
        ],
      ),
      padding: EdgeInsets.fromLTRB(27, 22, 27, 22),
      child: child,
    );

Widget box3({required Widget child}) => Container(
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.all(Radius.circular(20)),
        // border: BoxBorder(
        //   Padding(padding: EdgeInsets.fromLTRB(20.0, 12.0, 12.0, 12.0)),
        // ),
        boxShadow: <BoxShadow>[
          BoxShadow(
            color: Colors.black12,
            blurRadius: 5,
            //offset: Offset(4, 4),
            spreadRadius: 3,
          ),
        ],
      ),
      padding: EdgeInsets.fromLTRB(20, 22, 20, 22),
      child: child,
    );

Widget icon_card({required Widget child}) => Container(
    width: 50,
    height: 50,
    decoration: BoxDecoration(boxShadow: <BoxShadow>[
      BoxShadow(color: Colors.black, blurRadius: 5, spreadRadius: 5)
    ]),
    child: Container(
      child: Card(
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(10),
        ),
        color: Colors.white,
      ),
    ));
