import 'package:flutter/material.dart';

Widget buildBox({required Widget child}) => Container(
      decoration: BoxDecoration(
        color: Colors.white,
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
