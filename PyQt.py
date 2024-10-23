

import os
from datetime import date
from thonny import get_workbench
from thonny.languages import tr
from thonny.ui_utils import select_sequence




def add_pyqt_code():
     get_workbench().get_editor_notebook().get_current_editor().get_code_view().text.insert('0.0',
	 '''from PyQt5.uic import loadUi
from PyQt5.QtWidgets import QApplication,QMessageBox,QTableWidget,QTableWidgetItem



app = QApplication([])
form = loadUi ("Nom_Interface.ui")
form.show()
form.Nom_Bouton.clicked.connect (Nom_Module)
app.exec_()'''
)


def load_plugin():
    
    get_workbench().add_command(
        "selmen_command",
        "tools",
        tr("Ajouter code PyQt5"),
        add_pyqt_code,
		default_sequence=select_sequence("<Control-Shift-B>", "<Command-Shift-B>"),
    )
    
    # en cas ou la date est erroné sur le pc
    if date.today().year <2022 :
        cwd = 'C:\\Bac2023'
    else:
        cwd = 'C:\\Bac'+str(date.today().year)
    if not os.path.exists(cwd):
        os.makedirs(cwd)
    get_workbench().set_local_cwd(cwd)
    



