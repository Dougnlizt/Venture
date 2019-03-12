; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

#define MyAppName "TJCS Lottery"
#define MyAppVersion "1.3.0"
#define MyAppPublisher "dougnlizt@gmail.com"
#define MyAppExeName "javaw.exe"

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{B6DB2197-C2B1-41DD-9322-5C29B72742D2}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
DefaultDirName=C:\TJCS_Lottery\Venture
DefaultGroupName={#MyAppName}
AllowNoIcons=yes
OutputDir="C:\MyProjects\Venture\binary\{#MyAppVersion}"
OutputBaseFilename=TJCS_LotteryInstallx64
SetupIconFile=C:\MyProjects\Venture\src\main\resources\images\letter-l-48.ico
Compression=lzma
SolidCompression=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
;Source: "C:\TJCS_Lottery\java\jre1.8.0_161\bin\javaw.exe"; DestDir: "{app}"; Flags: ignoreversion

Source: "C:\Temp\java\jre1.8.0_161\*"; DestDir: "{app}\java\jre1.8.0_161\";  Flags: 64bit allowunsafefiles ignoreversion onlyifdoesntexist recursesubdirs createallsubdirs
Source: "C:\MyProjects\Venture\binary\{#MyAppVersion}\Venture.jar"; DestDir: "{app}"; Flags: 64bit allowunsafefiles confirmoverwrite ignoreversion promptifolder replacesameversion
;Icon(s)
Source: "C:\MyProjects\Venture\src\main\resources\images\letter-l-48.ico"; DestDir: "{app}"; Flags: ignoreversion
;Change History
Source: "C:\MyProjects\Venture\src\main\java\ChangeHistory.html"; DestDir: "{app}"; Flags: ignoreversion

; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{group}\{#MyAppName}"; Filename: "{app}\java\jre1.8.0_161\bin\javaw.exe"; Parameters: "-jar ""{app}\Venture.jar"""; IconFilename: "{app}\letter-l-48.ico"
;Name: "{group}\{cm:UninstallProgram,{#MyAppName}}"; Filename: "{app}\java\jre1.8.0_161\bin\javaw.exe"; Parameters: "-jar ""{app}\Venture.jar"""; IconFilename: "{app}\letter-l-48.ico"
Name: "{group}\{cm:UninstallProgram,{#MyAppName}}"; Filename: "{uninstallexe}"
Name: "{commondesktop}\{#MyAppName}"; Tasks: desktopicon; Filename: "{app}\java\jre1.8.0_161\bin\javaw.exe"; Parameters: "-jar ""{app}\Venture.jar"""; IconFilename: "{app}\letter-l-48.ico"

[Run]
Filename: "{app}\java\jre1.8.0_161\bin\javaw.exe"; Parameters: "-jar ""{app}\Venture.jar"""; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}"; Flags: nowait postinstall skipifsilent

