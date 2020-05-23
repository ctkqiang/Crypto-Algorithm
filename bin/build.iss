; Build Installation
; THis is an installer for Windows Machine

[Setup]
AppName=哈希計算器
AppVersion=1.0
WizardStyle=modern
DefaultDirName={autopf}\哈希計算器
DefaultGroupName=哈希計算器
UninstallDisplayIcon={app}\哈希計算器.exe
Compression=lzma2∑
SolidCompression=yes
;OutputDir=userdocs:Inno Setup Examples Output

[Files]
Source: "D:\CryptoJava\bin\HashCalculator\main.exe"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs
Source: "D:\CryptoJava\bin\HashCalculator\__pycache__\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs
Source: "D:\CryptoJava\bin\HashCalculator\build\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs
Source: "D:\CryptoJava\bin\HashCalculator\main.spec"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs
Source: "D:\CryptoJava\bin\HashCalculator\icon.png"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs


; Source: "哈希計算器.chm"; DestDir: "{app}"
; Source: "Readme.txt"; DestDir: "{app}"; Flags: isreadme

[Icons]
Name: "{group}\哈希計算器"; Filename: "{app}\icon.png"; Tasks: desktopicon

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked