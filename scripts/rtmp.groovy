script {
    RTMPDUMP = 'C:\\rtmpdump.exe'

    profile ('RTMP(E)') {
        pattern {
            protocol ([ 'rtmp', 'rtmpe' ])
        }

        action {
            def strings = $URI.split('!!!pms_ch_dash_y!!!')
            if (strings.length > 1)
                $URI = strings[0] + '" -y "' + strings[1]
			def strings1 = $URI.split('!!!pms_ch_dash_w!!!')
			if (strings.length > 1)
                $URI = strings[0] + '" -W "' + strings[1]
            $DOWNLOADER = "$RTMPDUMP -o $DOWNLOADER_OUT -r \"${$URI}\""
        }
    }
}