import hashlib
import tkinter as tk
from tkinter import *
from tkinter import messagebox as box
import tkinter.font as font
from tkinter.filedialog import askopenfilename
from tkinter import filedialog as tkFileDialog
import webbrowser as webservice

window = Tk()
window.resizable(width=False, height=False)
window.configure(bg="white")
labelframe1 = LabelFrame(window, text="哈希計算器")
labelframe1.pack(fill="both", expand="yes", padx=8, pady=1)
labelframe1.configure(bg="white")
myfont = font.Font(family="KaiTi")
input = tk.StringVar()
filename = StringVar()
sha256output = StringVar()
sha512output = StringVar()
md5output = StringVar()

sha1 = hashlib.sha1()
sha256 = hashlib.sha256()
sha512 = hashlib.sha512()
md5 = hashlib.md5()


def browsefile():
    filename.set(askopenfilename(initialdir="/",
                                 filetypes=(("Text File", "*.txt"),
                                            ("All Files", "*.*")),
                                 title="選擇文件"
                                 ))


def browsefilesha256():
    sha256output.set(askopenfilename(initialdir="/",
                                     filetypes=(("Text File", "*.txt"),
                                                ("All Files", "*.*")),
                                     title="選擇文件"
                                     ))


def browsefilesha512():
    sha512output.set(askopenfilename(initialdir="/",
                                     filetypes=(("Text File", "*.txt"),
                                                ("All Files", "*.*")),
                                     title="選擇文件"
                                     ))


def browsefilemd5():
    md5output.set(askopenfilename(initialdir="/",
                                  filetypes=(("Text File", "*.txt"),
                                             ("All Files", "*.*")),
                                  title="選擇文件"
                                  ))


def sha_one():
    hash_obj = filename.get()
    sha1 = hashlib.sha1(hash_obj.encode())
    estr = sha1.hexdigest()
    estr1 = estr.encode("utf-8")
    estr2 = estr1.decode("utf-8")
    print(hash_obj, "SHA 1 哈希計算結果: ", estr)
    box.showinfo("SHA 1 哈希計算結果", estr1)


def sha256():
    # SHA 256:
    hash_obj = filename.get()
    sha256 = hashlib.sha256(hash_obj.encode())
    sha256str = sha256.hexdigest()
    sha256str1 = sha256str.encode("utf-8")
    sha256str2 = sha256str1.decode("utf-8")
    print(hash_obj, "SHA 256 哈希計算結果: ", sha256str)
    box.showinfo("SHA 256 哈希計算結果", sha256str)


def sha512():
    hash_obj = filename.get()
    sha512 = hashlib.sha512(hash_obj.encode())
    sha512str = sha512.hexdigest()
    sha512str1 = sha512str.encode("utf-8")
    sha512str2 = sha512str1.decode("utf-8")
    print(hash_obj, "SHA 512 哈希計算結果: ", sha512str)
    box.showinfo("SHA 512 哈希計算結果", sha512str)


def md5():
    hash_obj = filename.get()
    md5 = hashlib.md5(hash_obj.encode())
    md5str = md5.hexdigest()
    md5str1 = md5str.encode("utf-8")
    md5str2 = md5str1.decode("utf-8")
    print(hash_obj, "MD5 哈希計算結果: ", md5str)
    box.showinfo("MD5 哈希計算結果", md5str)


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
    webservice.open("https://johnmelodyme.github.io/")


window.title("复述校驗")
window.geometry("680x150+500+150")
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

FileLocation = tk.Label(window, text="SHA-1： ", bg="white", justify=LEFT).place(
    x=12, y=18, width=84, height=24)

FileLocationsha256 = tk.Label(window, text="SHA-256: ", bg="white", justify=LEFT).place(
    x=12, y=50, width=84, height=24)

FileLocationsha256 = tk.Label(window, text="SHA-512: ", bg="white", justify=LEFT).place(
    x=12, y=82, width=84, height=24)

FileLocationmd5 = tk.Label(window, text="MD5: ", bg="white", justify=LEFT).place(
    x=12, y=114, width=84, height=24)

entry = tk.Entry(window, textvariable=filename, bg="#FAFAFA", justify=LEFT).place(
    x=100, y=18, width=400, height=24)

sha256entry = tk.Entry(window, textvariable=sha256output, bg="#FAFAFA", justify=LEFT).place(
    x=100, y=50, width=400, height=24)

sha512entry = tk.Entry(window, textvariable=sha512output, bg="#FAFAFA", justify=LEFT).place(
    x=100, y=82, width=400, height=24)

md5entry = tk.Entry(window, textvariable=md5output, bg="#FAFAFA", justify=LEFT).place(
    x=100, y=114, width=400, height=24)

browse = tk.Button(window, text="瀏覽", command=browsefile)
browse.place(x=520, y=18, width=50, height=24)
browse.configure(bg="white")

calculate = tk.Button(window, text="盤算", command=sha_one)
calculate.place(x=580, y=18, width=57, height=24)
calculate.configure(bg="white")

browsefileforsha256 = tk.Button(window, text="瀏覽", command=browsefilesha256)
browsefileforsha256.place(x=520, y=50, width=50, height=24)
browsefileforsha256.configure(bg="white")

calculatesha256 = tk.Button(window, text="盤算", command=sha256)
calculatesha256.place(x=580, y=50, width=57, height=24)
calculatesha256.configure(bg="white")

browse512 = tk.Button(window, text="瀏覽", command=browsefilesha512)
browse512.place(x=520, y=82, width=50, height=24)
browse512.configure(bg="white")

calculatesha512 = tk.Button(window, text="盤算", command=sha512)
calculatesha512.place(x=580, y=82, width=57, height=24)
calculatesha512.configure(bg="white")

browsemd5 = tk.Button(window, text="瀏覽", command=browsefilemd5)
browsemd5.place(x=520, y=114, width=50, height=24)
browsemd5.configure(bg="white")

calculatemd5 = tk.Button(window, text="盤算", command=md5)
calculatemd5.place(x=580, y=114, width=57, height=24)
calculatemd5.configure(bg="white")

window.config(menu=menu_bar)
window.mainloop()
