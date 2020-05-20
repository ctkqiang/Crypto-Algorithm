import os
import tkinter as tk
from tkinter import *
from tkinter import messagebox as box
import tkinter.font as font

window = Tk()
myfont = font.Font(family="KaiTi")


def main():
    window.title("复述校驗")
    window.geometry("600x300+500+150")
    window.iconphoto(window, PhotoImage(file="icon.png"))
    menu_bar = Menu(window)
    file = Menu(menu_bar, tearoff=0)
    file.add_command(label="匯出資料", command=exportData)
    file.add_command(label="退出", command=exit)
    menu_bar.add_cascade(label="文件", menu=file)
    about = Menu(menu_bar, tearoff=0)
    about.add_command(label="訪問網站", command=visitWebsite)
    about.add_command(label="開發人員", command=aboutDeveloper)
    menu_bar.add_cascade(label="關於", menu=about)
    window.config(menu=menu_bar)
    window.mainloop()

def exportData():
    print("export data")


def exit():
    window.destroy()


def aboutDeveloper():
    box.showinfo("我知道了", "此應用程序是由<<John Melody Me>> 創建")


def visitWebsite():
    os.system("start https://johnmelodyme.github.io/")


if __name__ == "__main__":
    main()
