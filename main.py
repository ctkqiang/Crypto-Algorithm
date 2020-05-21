import os
import hashlib
import tkinter as tk
from tkinter import *
from tkinter import messagebox as box
import tkinter.font as font
from tkinter.filedialog import askopenfilename
from tkinter import filedialog as tkFileDialog

window = Tk()
window.resizable(width=False, height=False)
window.configure(bg="white")
labelframe1 = LabelFrame(window, text="哈希計算器")
labelframe1.pack(fill="both", expand="yes", padx=8, pady=1)
labelframe1.configure(bg="white")
myfont = font.Font(family="KaiTi")
input = tk.StringVar()
filename = StringVar()
sha1output = StringVar()

sha1 = hashlib.sha1()
sha256 = hashlib.sha256()
sha512 = hashlib.sha512()
md5 = hashlib.md5()


# SHA 1
hash_obj = filename.get()
sha1 = hashlib.sha256(hash_obj.encode())
estr = sha1.hexdigest()
estr1 = estr.encode("utf-8")
estr2 = estr1.decode("utf-8")


def browsefile():
    filename.set(askopenfilename(initialdir="/",
                                 filetypes=(("Text File", "*.txt"),
                                            ("All Files", "*.*")),
                                 title="選擇文件"
                                 ))


def sha_one():
    print(hash_obj, estr)
    box.showinfo("SHA 1 哈希計算結果", estr1)


def exportData():
    data = open("hashes_output.txt", "w+")
    for i in range(10):
        data.write(estr2)
        data.close()


def exit():
    window.destroy()


def aboutDeveloper():
    box.showinfo("關於", "此應用程序是由<<John Melody Me>> 創建")


def visitWebsite():
    os.system("start https://johnmelodyme.github.io/")


window.title("复述校驗")
window.geometry("650x350+500+150")
window.iconphoto(window, PhotoImage(file="icon.png"))
menu_bar = Menu(window)
menu_bar.config(bg="white")
file = Menu(menu_bar, tearoff=0)
file.config(bg="white")
file.add_command(label="匯出資料", command=exportData)
file.add_command(label="退出", command=exit)
menu_bar.add_cascade(label="文件", menu=file)
menu_bar.config(bg="white")
about = Menu(menu_bar, tearoff=0)
about.config(bg="white")
about.add_command(label="訪問網站", command=visitWebsite)
about.add_command(label="開發人員", command=aboutDeveloper)
menu_bar.add_cascade(label="關於", menu=about)

FileLocation = tk.Label(window, text="SHA-1： ", bg="white").place(
    x=12, y=18, width=84, height=24)

entry = tk.Entry(window, textvariable=filename, bg="#FAFAFA").place(
    x=100, y=18, width=400, height=24)

browse = tk.Button(window, text="瀏覽", command=browsefile)
browse.place(x=520, y=18, width=50, height=24)
browse.configure(bg="white")
calculate = tk.Button(window, text="盤算", command=sha_one)
calculate.place(x=580, y=18, width=57, height=24)
calculate.configure(bg="white")

window.config(menu=menu_bar)
window.mainloop()
